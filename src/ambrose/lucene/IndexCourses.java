package ambrose.lucene;

import martini.util.DB;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import cm.SelectCourseForIndexing;
import cm.SelectCourseForIndexingResultSet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

public class IndexCourses {

	public static void main( String[] args )
		throws Exception
	{

		String indexPath = "index";
		boolean create = true;

		Date start = new Date();
		try 
		{
			System.out.println( "Indexing to directory '" + indexPath + "'..." );

			File file = new File( indexPath );
			Directory dir = FSDirectory.open( file );
			Analyzer analyzer = new StandardAnalyzer( Version.LUCENE_46 );
			IndexWriterConfig iwc = new IndexWriterConfig( Version.LUCENE_46, analyzer );

			OpenMode mode = create ? OpenMode.CREATE : OpenMode.CREATE_OR_APPEND;
			iwc.setOpenMode( mode );

			// Optional: for better indexing performance, if you
			// are indexing many documents, increase the RAM
			// buffer. But if you do this, increase the max heap
			// size to the JVM (eg add -Xmx512m or -Xmx1g):
			//
			// iwc.setRAMBufferSizeMB(256.0);

			IndexWriter writer = new IndexWriter( dir, iwc );
			indexCourses( writer );

			// NOTE: if you want to maximize search performance,
			// you can optionally call forceMerge here. This can be
			// a terribly costly operation, so generally it's only
			// worth it when your index is relatively static (ie
			// you're done adding documents to it):
			//
			// writer.forceMerge(1);

			writer.close();

			Date end = new Date();
			long elapsed = end.getTime() - start.getTime();
			System.out.println( elapsed + " total milliseconds" );

		} 
		catch( Exception e ) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Indexes the given file using the given writer, or if a directory is
	 * given, recurses over files and directories found under the given
	 * directory.
	 * 
	 * NOTE: This method indexes one document per input file. This is slow. For
	 * good throughput, put multiple documents into your input file(s). An
	 * example of this is in the benchmark module, which can create "line doc"
	 * files, one document per line, using the <a href=
	 * "../../../../../contrib-benchmark/org/apache/lucene/benchmark/byTask/tasks/WriteLineDocTask.html"
	 * >WriteLineDocTask</a>.
	 * 
	 * @param writer
	 *            Writer to the index where the given file/dir info will be
	 *            stored
	 * @param file
	 *            The file to index, or the directory to recurse into to find
	 *            files to index
	 * @throws IOException
	 */
	
	static void indexCourses( IndexWriter writer )
		throws Exception
	{
		DB cm = new DB();
		cm.setDriver( "org.h2.Driver" );
		cm.setURL( "jdbc:h2:tcp://localhost/~/git/martini/db/cm" );
		cm.setUsername( "sa" );
		Connection connection = cm.getConnection();
		
		int count = 0;
		SelectCourseForIndexing select = new SelectCourseForIndexing( connection );
		SelectCourseForIndexingResultSet rs = select.execute();
		while( rs.hasNext() )
		{
			Document doc = new Document();

			{
				long id = rs.getId();
				LongField field = new LongField( "id", id, Field.Store.YES );
				doc.add( field );
			}
			
			{
				String dept = rs.getDepartment_abbrev();
				dept = dept.toLowerCase();
				StringField field = new StringField( "dept", dept, Field.Store.YES );
//				TextField field = new TextField( "dept", dept, Field.Store.YES );
				doc.add( field );
			}
			
			{
				int num = rs.getCourse_number();
				IntField field = new IntField( "num", num, Field.Store.YES );
				doc.add( field );
			}
			
			{
				String course = Integer.toString( rs.getCourse_number() );
				StringField field = new StringField( "course", course, Field.Store.YES );
				doc.add( field );
			}
			
			{
				String catalog = rs.getLong_course_title();
				TextField field = new TextField( "catalog", catalog, Field.Store.YES );
				doc.add( field );
			}
			
			{
				if( rs.hasCourse_title() )
				{
					String transcript = rs.getCourse_title();
					TextField field = new TextField( "transcript", transcript, Field.Store.YES );
					doc.add( field );
				}
			}
			
			{
				if( rs.hasDescription() )
				{
					String description = rs.getDescription();
					TextField field = new TextField( "description", description, Field.Store.YES );
					doc.add( field );
				}
			}
			
			{
				String college = rs.getCourse_college();
				StringField field = new StringField( "college", college, Field.Store.YES );
				doc.add( field );
			}
			
			{
				int branch = rs.getCourse_branch();
				IntField field = new IntField( "branch", branch, Field.Store.YES );
				doc.add( field );
			}
			
			{
				int lastATP = rs.getLastATP();
				IntField field = new IntField( "lastATP", lastATP, Field.Store.YES );
				doc.add( field );
			}
			
			{
				int firstATP = rs.getFirstATP();
				IntField field = new IntField( "firstATP", firstATP, Field.Store.YES );
				doc.add( field );
			}
			
			
			writer.addDocument(doc);
			count++;
		}
		System.out.println( "courses indexed: " + count );
	}
	
}

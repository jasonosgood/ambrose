package ambrose.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;


public class 
	SearchCourseIndex 
{

	public static void main(String[] args) 
		throws Exception 
	{
//		int lastATP = 99994;
//		int year = lastATP / 10;
//		int term = lastATP % 10;
//		
//		System.out.printf( "gorp %d/%d", year, term );

		SearchCourseIndex ugh = new SearchCourseIndex();
		ugh.search();
	}
	
	public SearchCourseIndex() {}
	
	public void search()
		throws Exception
	{
		String index = "index";
		int hitsPerPage = 10;

	    File file = new File( index );
		FSDirectory dir = FSDirectory.open( file );
		IndexReader reader = DirectoryReader.open( dir );
		
		IndexSearcher searcher = new IndexSearcher( reader );
		Analyzer analyzer = new StandardAnalyzer( Version.LUCENE_46 );

//		String[] fieldList = { "dept", "num" };
//		String field = "contents";
		QueryParser parser = new QueryParser( Version.LUCENE_46, "dept", analyzer );
//		String[] fieldList = { "dept", "num", "course", "catalog", "transcript", "description" };
		String[] fieldList = { "dept" };
//		MultiFieldQueryParser parser = new MultiFieldQueryParser( Version.LUCENE_46, fieldList, analyzer );
		
//		String queryString = "ACCTG and 401";
//		String queryString = "+dept:ACCTG and +course:401";
//		String queryString = "dept:ACCTG and course:401";
//		String queryString = "401";
//		String queryString = "ACCTG";
		String queryString = "dept:ACCTG";
//		String queryString = "+dept:ACCTG +num:[301 TO 399]";
//		String queryString = "course:{301 TO 399}";
//		String queryString = "description:english";
		Query query = parser.parse(queryString);
		
//		Query numQuery = NumericRangeQuery.newIntRange( "num", 1, 401, 401, true, true );
//		BooleanQuery booleanQuery = new BooleanQuery();
////		booleanQuery.add( numQuery, BooleanClause.Occur.MUST );
//		booleanQuery.add( query, BooleanClause.Occur.MUST );
		
		Date start = new Date();
		
		System.out.println( "Searching for: " + query.toString() );
		Sort sort = new Sort( new SortField( "num", SortField.Type.INT, false ));
		TopDocs results = searcher.search( query, 100,  sort );


//		System.out.println(numTotalHits + " total matching documents");
		Date end = new Date();
		System.out.println( "Time: " + ( end.getTime() - start.getTime() ) + "ms" );
		int count = 0;
		for( ScoreDoc scoreDoc: results.scoreDocs )
		{
			Document doc = searcher.doc( scoreDoc.doc );
//			doc.
			String dept = doc.get( "dept" );
			String num = doc.get( "num" );
			String catalog = doc.get( "catalog" );
			String transcript = doc.get( "transcript" );
			String description = doc.get( "description" );
			int firstATP = doc.getField( "firstATP" ).numericValue().intValue();
			int lastATP = doc.getField( "lastATP" ).numericValue().intValue();
			System.out.printf( "%s %s %s %s %s %s %s%n", dept, num, catalog, transcript, description, yearTerm( firstATP ), yearTerm( lastATP ));
			count++;
//			if( count == 10 ) break;
		}

//		searcher.close();
		reader.close();
	}
	
	public static String yearTerm( int yearTerm ) 
	{
		int year = yearTerm / 10;
		int term = yearTerm % 10;
		
		return String.format( "%d/%d", year, term );
	}
}

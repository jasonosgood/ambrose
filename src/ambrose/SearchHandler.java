package ambrose;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import martini.model.Handler;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import ambrose.Search;
import ambrose.SearchPagesItem;
import ambrose.SearchResultsItem;
import ambrose.lucene.SearchCourseIndex;

public class
	SearchHandler
extends
	Handler<Search>
{
	private String _indexFile = "index";
	
	public void setIndexFile( String indexFile )
		throws FileNotFoundException
	{
		if( indexFile == null )
		{
			throw new NullPointerException( "indexFile" );
		}
		File file = new File( indexFile );
		if( !file.exists() )
		{
			throw new FileNotFoundException( indexFile );
		}
		_indexFile = indexFile;
	}
	
	public String getIndexFile()
	{
		return _indexFile;
	}
	
	int hitsPerPage = 10;
	int numTotalHits = 0;
	
	@Override
	public void GET( Search page, HttpServletRequest request, HttpServletResponse response ) 
		throws Exception
	{
		List<SearchResultsItem> resultList = page.getResults();
		resultList.clear();
		
		List<SearchPagesItem> paginationList = page.getPages();
		paginationList.clear();

		HttpSession session = request.getSession( true );
		Object username = session.getAttribute( "username" ); 
//		page.setUsername( username == null ? "" : username );
		
		String metrics = page.getMetrics().toString();
		
		String queryString = page.getSearchForm().getQ().toString().trim();
		
		if( queryString.length() == 0 ) 
		{
			page.setMetrics( "" );
			return;
		}
		
		String startText = page.getSearchForm().getStart().toString().trim();
		int start = 0;
		if( startText.length() > 0 ) 
		{
			try
			{
				start = Integer.valueOf( startText );
			}
			catch( NumberFormatException e )
			{
				e.printStackTrace();
			}
		}		

		{
			String field = "description";
			
			String indexFile = getIndexFile();
			File file = new File( indexFile );
			IndexReader reader = IndexReader.open( FSDirectory.open( file ));
			
			IndexSearcher searcher = new IndexSearcher( reader );
			Analyzer analyzer = new StandardAnalyzer( Version.LUCENE_46 );

			QueryParser parser = new QueryParser( Version.LUCENE_46, field, analyzer );
//			String[] fieldList = { "dept", "num", "catalogTitle", "transcriptTitle", "description" };
//			String[] fieldList = { "dept", "num" };
//			MultiFieldQueryParser parser = new MultiFieldQueryParser( Version.LUCENE_46, fieldList, analyzer );
			
			Query query = parser.parse( queryString );
			
			System.out.println( "Searching for: " + query.toString( field ));
	
//			long now = System.currentTimeMillis();
			Sort sort = new Sort( new SortField( "num", SortField.Type.INT, false ));
			TopDocs results = searcher.search( query, 100,  sort );
	
			numTotalHits = results.totalHits;
			
			metrics = String.format( metrics, numTotalHits );
			page.setMetrics( metrics );
	       
			for( int nth = 0; nth < results.scoreDocs.length; nth++ )
			{
				if( nth < start ) continue;
				if( nth == start + hitsPerPage ) break;
				ScoreDoc scoreDoc = results.scoreDocs[nth];
				Document doc = searcher.doc( scoreDoc.doc );
				String dept = doc.get( "dept" ).toUpperCase();
				String num = doc.get( "num" );
				String catalogTitle = doc.get( "catalog" );
				String transcriptTitle = doc.get( "transcript" );
				String description = doc.get( "description" );
				if( description == null )
				{
					description = "(no description)";
				}
				int firstATP = doc.getField( "firstATP" ).numericValue().intValue();
				int lastATP = doc.getField( "lastATP" ).numericValue().intValue();
				System.out.printf( "%s %s %s %s %s\n", dept, num, catalogTitle, transcriptTitle, description );
				SearchResultsItem item = new SearchResultsItem();
				item.setCourse( String.format( "%s %s", dept, num ));
				item.setCatalog( catalogTitle );
				item.setDescription( description );
				String[] campii = new String[] { "Seattle", "Tacoma", "Bothell" };
// 				item.setCampus( campii[0] );
// 				item.setAtps( yearTerm( firstATP ) + " - " + yearTerm( lastATP ));
				item.setLinkHref( String.format( "course/%s/%s/%d", dept, num, lastATP ));
				resultList.add( item );
			}
			reader.close();
		}
		{
			if( startText.length() > 0 ) 
			{
				try
				{
					start = Integer.valueOf( startText );
				}
				catch( NumberFormatException e )
				{
					e.printStackTrace();
				}
			}
			// Round page offsets to multiples of hitsPerPage
			start = ( start % hitsPerPage ) * hitsPerPage;
			
			int begin = Math.max( 0, start - ( hitsPerPage * 3 ));
			int pages = numTotalHits / hitsPerPage;
			
			for( int nth = 0; nth < pages; nth++ )
			{
				SearchPagesItem item = new SearchPagesItem();
				item.setNth( Integer.toString( nth + 1 ));
				paginationList.add( item );
				
				item.setNthHref( "?q=" + URLEncoder.encode( queryString ) + "&start=" + ( nth * hitsPerPage ));
			}
		}
	}
	
	public static String yearTerm( int yearTerm ) 
	{
		int year = yearTerm / 10;
		int term = yearTerm % 10;
		
		return String.format( "%d/%d", year, term );
	}

}

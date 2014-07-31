package ambrose;
// Generated from null -- DO NOT MODIFY

import martini.model.Page;
import martini.HTMLBuilder;
import martini.model.*;
import static martini.util.Util.hasText;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Search extends Page
{

	@Override
	public String getURI() { return "/"; };

	@Override
	public void setUrlParams( Map<String,String> params ) {
	}

	private Object _metrics = null;
	public Object getMetrics() { return _metrics; }
	public void setMetrics( Object metrics ) {
		_metrics = metrics;
	}

	private SearchSearchForm _searchForm = null;
	public SearchSearchForm getSearchForm() { return _searchForm; }
	public void setSearchForm( SearchSearchForm searchForm ) {
		_searchForm = searchForm;
	}

	private List<SearchResultsItem> _results = new ArrayList<SearchResultsItem>();
	public List<SearchResultsItem> getResults() { return _results; }
	public void setResults( List<SearchResultsItem> results ) { _results = results; }

	private List<SearchPagesItem> _pages = new ArrayList<SearchPagesItem>();
	public List<SearchPagesItem> getPages() { return _pages; }
	public void setPages( List<SearchPagesItem> pages ) { _pages = pages; }

	public void render( HttpServletResponse response )
		throws ServletException, IOException 
	{
		setXMLWriter( response.getWriter() );
		document();
		element( "html" );
		attribute( "xmlns", "http://www.w3.org/1999/xhtml" );
		element( "head" );
		element( "title" );
		text( getTitle() );
		pop();
		element( "meta" );
		attribute( "charset", "utf-8" );
		pop();
		element( "meta" );
		attribute( "name", "viewport" );
		attribute( "content", "width=device-width, initial-scale=1.0" );
		pop();
		element( "link" );
		attribute( "href", "assets/css/bootstrap.css" );
		attribute( "rel", "stylesheet" );
		pop();
		pop();
		element( "body" );
		text( "\n\t" );
		element( "div" );
		attribute( "class", "container" );
		text( "\n\t\t" );
		element( "h1" );
		text( "Ambrose" );
		pop();
		text( "\n\t\t" );
		element( "form" );
		attribute( "enctype", "application/x-www-form-urlencoded" );
		attribute( "method", "get" );
		attribute( "class", "form-horizontal" );
		attribute( "martini", "search" );
		text( "\n\t\t    " );
		element( "div" );
		attribute( "class", "input-group" );
		text( "\n\t\t\t\t" );
		element( "input" );
		attribute( "type", "text" );
		attribute( "class", "form-control" );
		attribute( "name", "q" );
		attribute( "placeholder", "Search course catalog" );
		attribute( "value", getSearchForm().getQ() );
		pop();
		text( "\n\t\t\t\t" );
		element( "span" );
		attribute( "class", "input-group-btn" );
		text( "\n\t\t\t\t\t" );
		element( "button" );
		attribute( "type", "button" );
		attribute( "class", "btn btn-default" );
		element( "span" );
		attribute( "class", "glyphicon glyphicon-search" );
		pop();
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t    " );
		pop();
		text( "\n\t\t\t" );
		element( "input" );
		attribute( "type", "hidden" );
		attribute( "name", "start" );
		attribute( "value", getSearchForm().getStart() );
		pop();
		text( "\n\t\t" );
		pop();
		text( "\n\t\t" );
		element( "div" );
		attribute( "martini", "metrics" );
		text( getMetrics() );
		pop();
		text( "\n\t\t" );
		element( "ul" );
		attribute( "class", "list-unstyled" );
		attribute( "martini", "results" );
		for( SearchResultsItem item0 : getResults()  )
		{
			element( "li" );
			text( "\n\t\t\t\t" );
			element( "br" );
			attribute( "clear", "none" );
			pop();
			text( "\n\t\t\t\t" );
			element( "a" );
			attribute( "shape", "rect" );
			attribute( "martini", "link" );
			attribute( "href", item0.getLinkHref() );
			text( "\n\t\t\t\t\t" );
			element( "span" );
			attribute( "martini", "course" );
			text( item0.getCourse() );
			pop();
			text( "\n\t\t\t\t\t" );
			element( "span" );
			attribute( "martini", "catalog" );
			text( item0.getCatalog() );
			pop();
			text( "\n\t\t\t\t" );
			pop();
			text( "\n\t\t\t\t" );
			element( "div" );
			attribute( "martini", "description" );
			text( item0.getDescription() );
			pop();
			text( "\n\t\t\t\t" );
			text( "\n\t\t\t" );
			pop();
		}
		pop();
		text( "\n\t\t" );
		element( "br" );
		attribute( "clear", "none" );
		pop();
		text( "\n\t\t" );
		element( "ul" );
		attribute( "class", "pagination" );
		attribute( "martini", "pages" );
		for( SearchPagesItem item0 : getPages()  )
		{
			element( "li" );
			attribute( "class", "disabled" );
			element( "a" );
			attribute( "shape", "rect" );
			attribute( "martini", "nth" );
			attribute( "href", item0.getNthHref() );
			text( item0.getNth() );
			pop();
			pop();
		}
		pop();
		text( "\n \t" );
		pop();
		text( "\n" );
		pop();
		pop();
		close();
	}
	@Override
	public void populateForm( Map<String,String[]> params )
	{
		getSearchForm().setQ( getRequestParameter( params, "q" )); 
		getSearchForm().setStart( getRequestParameter( params, "start" )); 
	}
}

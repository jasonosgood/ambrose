package ambrose;
// Generated from null -- DO NOT MODIFY

import martini.model.Page;
import martini.model.*;
import static martini.util.Util.hasText;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Details extends Page
{

	@Override
	public String getURI() { return "/course/{dept}/{number}/{lastATP}"; };

	private String _deptParam = null;
	public String getDeptParam() { return _deptParam; }
	public void setDeptParam( String deptParam ) {
		_deptParam = deptParam;
	}

	private String _numberParam = null;
	public String getNumberParam() { return _numberParam; }
	public void setNumberParam( String numberParam ) {
		_numberParam = numberParam;
	}

	private String _lastATPParam = null;
	public String getLastATPParam() { return _lastATPParam; }
	public void setLastATPParam( String lastATPParam ) {
		_lastATPParam = lastATPParam;
	}

	@Override
	public void setUrlParams( Map<String,String> params ) {
		setDeptParam( params.get( "dept" ));
		setNumberParam( params.get( "number" ));
		setLastATPParam( params.get( "lastATP" ));
	}

	private DetailsDetailsForm _detailsForm = null;
	public DetailsDetailsForm getDetailsForm() { return _detailsForm; }
	public void setDetailsForm( DetailsDetailsForm detailsForm ) {
		_detailsForm = detailsForm;
	}

	public void render( HttpServletResponse response )
		throws ServletException, IOException 
	{
		setXMLWriter( response.getWriter() );
		document();
		element( "html" );
		attribute( "xmlns", "http://www.w3.org/1999/xhtml" );
		element( "head" );
		element( "meta" );
		attribute( "charset", "utf-8" );
		pop();
		element( "title" );
		text( getTitle() );
		pop();
		element( "meta" );
		attribute( "name", "viewport" );
		attribute( "content", "width=device-width, initial-scale=1.0" );
		pop();
		element( "link" );
		attribute( "href", "/assets/css/bootstrap.css" );
		attribute( "rel", "stylesheet" );
		pop();
		pop();
		element( "body" );
		text( "\n\t" );
		element( "div" );
		attribute( "class", "container" );
		text( "\n\t\t" );
		element( "h1" );
		attribute( "class", "col-sm-offset-2" );
		text( "Course Details" );
		pop();
		text( "\n\t\t" );
		element( "form" );
		attribute( "enctype", "application/x-www-form-urlencoded" );
		attribute( "method", "post" );
		attribute( "class", "form-horizontal" );
		attribute( "martini", "Details" );
		attribute( "role", "form" );
		text( "\n\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "label" );
		attribute( "class", "col-sm-2 control-label" );
		text( "Campus" );
		pop();
		text( "\n\t\t\t    " );
		element( "div" );
		attribute( "class", "col-xs-3" );
		text( "\n\t\t\t\t\t" );
		element( "select" );
		attribute( "class", "form-control" );
		attribute( "name", "campus" );
		for( Option option : getDetailsForm().getCampus() )
		{
			element( "option" );
			String value = option.getValue();
			if( hasText( value ))
			{
				attribute( "value", value );
			}
			if( option.getSelected() )
			{
				attribute( "selected", "selected" );
			}
			text( option.getText() );
			pop();
		}
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "label" );
		attribute( "class", "col-sm-2 control-label" );
		text( "College" );
		pop();
		text( "\n\t\t\t    " );
		element( "div" );
		attribute( "class", "col-xs-3" );
		text( "\n\t\t\t\t\t" );
		element( "select" );
		attribute( "class", "form-control" );
		attribute( "name", "college" );
		for( Option option : getDetailsForm().getCollege() )
		{
			element( "option" );
			String value = option.getValue();
			if( hasText( value ))
			{
				attribute( "value", value );
			}
			if( option.getSelected() )
			{
				attribute( "selected", "selected" );
			}
			text( option.getText() );
			pop();
		}
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "label" );
		attribute( "class", "col-sm-2 control-label" );
		text( "Department" );
		pop();
		text( "\n\t\t\t    " );
		element( "div" );
		attribute( "class", "col-xs-3" );
		text( "\n\t\t\t\t\t" );
		element( "select" );
		attribute( "class", "form-control" );
		attribute( "name", "dept" );
		for( Option option : getDetailsForm().getDept() )
		{
			element( "option" );
			String value = option.getValue();
			if( hasText( value ))
			{
				attribute( "value", value );
			}
			if( option.getSelected() )
			{
				attribute( "selected", "selected" );
			}
			text( option.getText() );
			pop();
		}
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n\t\t\t\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "label" );
		attribute( "class", "col-sm-2 control-label" );
		text( "Code" );
		pop();
		text( "\n\t\t\t    " );
		element( "div" );
		attribute( "class", "col-xs-4" );
		text( "\n\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "text" );
		attribute( "class", "form-control" );
		attribute( "style", "display: inline; width: 40%;" );
		attribute( "name", "abbrev" );
		attribute( "placeholder", "ENGL" );
		attribute( "value", getDetailsForm().getAbbrev() );
		pop();
		text( "\n\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "text" );
		attribute( "class", "form-control" );
		attribute( "style", "display: inline; width: 40%;" );
		attribute( "name", "number" );
		attribute( "placeholder", "000" );
		attribute( "value", getDetailsForm().getNumber() );
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n\t\t\t\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "label" );
		attribute( "class", "col-sm-2 control-label" );
		text( "Catalog" );
		pop();
		text( "\n\t\t\t\t" );
		element( "div" );
		attribute( "class", "col-sm-10" );
		text( "\n\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "text" );
		attribute( "class", "form-control" );
		attribute( "name", "catalog" );
		attribute( "placeholder", "Catalog title" );
		attribute( "value", getDetailsForm().getCatalog() );
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n\t\t\t\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "label" );
		attribute( "class", "col-sm-2 control-label" );
		text( "Transcript" );
		pop();
		text( "\n\t\t\t\t" );
		element( "div" );
		attribute( "class", "col-sm-10" );
		text( "\n\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "text" );
		attribute( "class", "form-control" );
		attribute( "name", "transcript" );
		attribute( "placeholder", "Transcript title, max 40 chars" );
		attribute( "value", getDetailsForm().getTranscript() );
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n\t\t\t\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "label" );
		attribute( "class", "col-sm-2 control-label" );
		text( "Description" );
		pop();
		text( "\n\t\t\t    " );
		element( "div" );
		attribute( "class", "col-sm-10" );
		text( "\n\t\t\t    \t" );
		element( "textarea" );
		attribute( "rows", "3" );
		attribute( "class", "form-control" );
		attribute( "name", "description" );
		attribute( "placeholder", "Ipsum lorem" );
		text( getDetailsForm().getDescription() );
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "label" );
		attribute( "class", "col-sm-2 control-label" );
		text( "Credits" );
		pop();
		text( "\n\t\t\t    " );
		element( "div" );
		attribute( "class", "col-xs-9" );
		text( "\n\t\t\t\t\t" );
		element( "select" );
		attribute( "class", "form-control" );
		attribute( "style", "display: inline; width: auto;" );
		attribute( "name", "credits" );
		for( Option option : getDetailsForm().getCredits() )
		{
			element( "option" );
			String value = option.getValue();
			if( hasText( value ))
			{
				attribute( "value", value );
			}
			if( option.getSelected() )
			{
				attribute( "selected", "selected" );
			}
			text( option.getText() );
			pop();
		}
		pop();
		text( "\n\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "text" );
		attribute( "class", "form-control" );
		attribute( "style", "display: inline; width: 10%;" );
		attribute( "name", "creditsMin" );
		attribute( "placeholder", "1" );
		attribute( "size", "2" );
		attribute( "value", getDetailsForm().getCreditsMin() );
		pop();
		text( "\n\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "text" );
		attribute( "class", "form-control" );
		attribute( "style", "display: inline; width: 10%;" );
		attribute( "name", "creditsMax" );
		attribute( "placeholder", "1" );
		attribute( "size", "2" );
		attribute( "value", getDetailsForm().getCreditsMax() );
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "label" );
		attribute( "class", "col-sm-2 control-label" );
		text( "Grading" );
		pop();
		text( "\n\t\t\t    " );
		element( "div" );
		attribute( "class", "col-xs-3" );
		text( "\n\t\t\t\t\t" );
		element( "select" );
		attribute( "class", "form-control" );
		attribute( "name", "grading" );
		attribute( "style", "width: auto;" );
		for( Option option : getDetailsForm().getGrading() )
		{
			element( "option" );
			String value = option.getValue();
			if( hasText( value ))
			{
				attribute( "value", value );
			}
			if( option.getSelected() )
			{
				attribute( "selected", "selected" );
			}
			text( option.getText() );
			pop();
		}
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "label" );
		attribute( "class", "col-sm-2 control-label" );
		text( "Start Term" );
		pop();
		text( "\n\t\t\t    " );
		element( "div" );
		attribute( "class", "col-sm-8" );
		text( "\n\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "text" );
		attribute( "class", "form-control" );
		attribute( "style", "display: inline; width: auto;" );
		attribute( "name", "startYear" );
		attribute( "size", "4" );
		attribute( "placeholder", "2013" );
		attribute( "value", getDetailsForm().getStartYear() );
		pop();
		text( "\n\t\t\t\t\t" );
		element( "select" );
		attribute( "class", "form-control" );
		attribute( "name", "startTerm " );
		attribute( "style", "display: inline; width: auto;" );
		for( Option option : getDetailsForm().getStartTerm () )
		{
			element( "option" );
			String value = option.getValue();
			if( hasText( value ))
			{
				attribute( "value", value );
			}
			if( option.getSelected() )
			{
				attribute( "selected", "selected" );
			}
			text( option.getText() );
			pop();
		}
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "label" );
		attribute( "class", "col-sm-2 control-label" );
		text( "End Term" );
		pop();
		text( "\n\t\t\t    " );
		element( "div" );
		attribute( "class", "col-sm-8" );
		text( "\n\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "text" );
		attribute( "class", "form-control" );
		attribute( "style", "display: inline; width: auto;" );
		attribute( "name", "endYear" );
		attribute( "placeholder", "9999" );
		attribute( "size", "4" );
		attribute( "value", getDetailsForm().getEndYear() );
		pop();
		text( "\n\t\t\t\t\t" );
		element( "select" );
		attribute( "class", "form-control" );
		attribute( "name", "endTerm" );
		attribute( "style", "display: inline; width: auto;" );
		for( Option option : getDetailsForm().getEndTerm() )
		{
			element( "option" );
			String value = option.getValue();
			if( hasText( value ))
			{
				attribute( "value", value );
			}
			if( option.getSelected() )
			{
				attribute( "selected", "selected" );
			}
			text( option.getText() );
			pop();
		}
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "label" );
		attribute( "class", "col-sm-2 control-label" );
		text( "Gen Ed Reqs" );
		pop();
		text( "\n\t\t\t    " );
		element( "div" );
		attribute( "class", "col-sm-8" );
		text( "\n\t\t\t\t\t" );
		element( "label" );
		attribute( "class", "checkbox" );
		text( "\n\t\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "checkbox" );
		attribute( "name", "gened_is" );
		attribute( "value", "is" );
		if( getDetailsForm().getGened_is() ) {
			attribute( "checked" );
		}
		pop();
		text( "\n\t\t\t\t\t\t" );
		text( "Individuals" );
		text( " " );
		text( "& Societies" );
		text( "\n\t\t\t\t\t" );
		pop();
		text( "\n\t\t\t\t\t" );
		element( "label" );
		attribute( "class", "checkbox" );
		text( "\n\t\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "checkbox" );
		attribute( "name", "gened_nw" );
		attribute( "value", "nw" );
		if( getDetailsForm().getGened_nw() ) {
			attribute( "checked" );
		}
		pop();
		text( "\n\t\t\t\t\t\t" );
		text( "The Natural World" );
		text( "\n\t\t\t\t\t" );
		pop();
		text( "\n\t\t\t\t\t" );
		element( "label" );
		attribute( "class", "checkbox" );
		text( "\n\t\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "checkbox" );
		attribute( "name", "gened_vpla" );
		attribute( "value", "vlpa" );
		if( getDetailsForm().getGened_vpla() ) {
			attribute( "checked" );
		}
		pop();
		text( "\n\t\t\t\t\t\t" );
		text( "Visual, Literary, and Performing Arts" );
		text( "\n\t\t\t\t\t" );
		pop();
		text( "\n\t\t\t\t\t" );
		element( "label" );
		attribute( "class", "checkbox" );
		text( "\n\t\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "checkbox" );
		attribute( "name", "gened_writing" );
		attribute( "value", "writing" );
		if( getDetailsForm().getGened_writing() ) {
			attribute( "checked" );
		}
		pop();
		text( "\n\t\t\t\t\t\t" );
		text( "Additional Writing" );
		text( "\n\t\t\t\t\t" );
		pop();
		text( "\n\t\t\t\t\t" );
		element( "label" );
		attribute( "class", "checkbox" );
		text( "\n\t\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "checkbox" );
		attribute( "name", "gened_div" );
		attribute( "value", "div" );
		if( getDetailsForm().getGened_div() ) {
			attribute( "checked" );
		}
		pop();
		text( "\n\t\t\t\t\t\t" );
		text( "Diversity" );
		text( "\n\t\t\t\t\t" );
		pop();
		text( "\n\t\t\t\t\t" );
		element( "label" );
		attribute( "class", "checkbox" );
		text( "\n\t\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "checkbox" );
		attribute( "name", "gened_comp" );
		attribute( "value", "comp" );
		if( getDetailsForm().getGened_comp() ) {
			attribute( "checked" );
		}
		pop();
		text( "\n\t\t\t\t\t\t" );
		text( "English Composition" );
		text( "\n\t\t\t\t\t" );
		pop();
		text( "\n\t\t\t\t\t" );
		element( "label" );
		attribute( "class", "checkbox" );
		text( "\n\t\t\t\t\t\t" );
		element( "input" );
		attribute( "type", "checkbox" );
		attribute( "name", "gened_qsr" );
		attribute( "value", "qsr" );
		if( getDetailsForm().getGened_qsr() ) {
			attribute( "checked" );
		}
		pop();
		text( "\n\t\t\t\t\t\t" );
		text( "Quantitative, Symbolic, or Formal Reasoning" );
		text( "\n\t\t\t\t\t" );
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n\n\t\t\t" );
		element( "div" );
		attribute( "class", "form-group" );
		text( "\n\t\t\t\t" );
		element( "div" );
		attribute( "class", "col-sm-offset-2 col-sm-8" );
		text( "\n\t\t\t\t\t" );
		element( "button" );
		attribute( "type", "submit" );
		attribute( "class", "btn" );
		text( "Save" );
		pop();
		text( "\n\t\t\t\t" );
		pop();
		text( "\n\t\t\t" );
		pop();
		text( "\n  \t\t\t" );
		element( "input" );
		attribute( "type", "hidden" );
		attribute( "name", "id" );
		attribute( "value", getDetailsForm().getId() );
		pop();
		text( "\n\t\t\t\n\t\t" );
		pop();
		text( "\n\t" );
		pop();
		text( "\n" );
		pop();
		pop();
		close();
	}
	@Override
	public void populateForm( Map<String,String[]> params )
	{
		getDetailsForm().getCampus().setValue( getRequestParameter( params, "campus" )); 
		getDetailsForm().getCollege().setValue( getRequestParameter( params, "college" )); 
		getDetailsForm().getDept().setValue( getRequestParameter( params, "dept" )); 
		getDetailsForm().setAbbrev( getRequestParameter( params, "abbrev" )); 
		getDetailsForm().setNumber( getRequestParameter( params, "number" )); 
		getDetailsForm().setCatalog( getRequestParameter( params, "catalog" )); 
		getDetailsForm().setTranscript( getRequestParameter( params, "transcript" )); 
		getDetailsForm().setDescription( getRequestParameter( params, "description" )); 
		getDetailsForm().getCredits().setValue( getRequestParameter( params, "credits" )); 
		getDetailsForm().setCreditsMin( getRequestParameter( params, "creditsMin" )); 
		getDetailsForm().setCreditsMax( getRequestParameter( params, "creditsMax" )); 
		getDetailsForm().getGrading().setValue( getRequestParameter( params, "grading" )); 
		getDetailsForm().setStartYear( getRequestParameter( params, "startYear" )); 
		getDetailsForm().getStartTerm ().setValue( getRequestParameter( params, "startTerm " )); 
		getDetailsForm().setEndYear( getRequestParameter( params, "endYear" )); 
		getDetailsForm().getEndTerm().setValue( getRequestParameter( params, "endTerm" )); 
		getDetailsForm().setGened_is( hasRequestParameter( params, "gened_is" )); 
		getDetailsForm().setGened_nw( hasRequestParameter( params, "gened_nw" )); 
		getDetailsForm().setGened_vpla( hasRequestParameter( params, "gened_vpla" )); 
		getDetailsForm().setGened_writing( hasRequestParameter( params, "gened_writing" )); 
		getDetailsForm().setGened_div( hasRequestParameter( params, "gened_div" )); 
		getDetailsForm().setGened_comp( hasRequestParameter( params, "gened_comp" )); 
		getDetailsForm().setGened_qsr( hasRequestParameter( params, "gened_qsr" )); 
		getDetailsForm().setId( getRequestParameter( params, "id" )); 
	}
}

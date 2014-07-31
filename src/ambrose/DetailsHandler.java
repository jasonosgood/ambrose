package ambrose;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ambrose.Details;
import ambrose.DetailsDetailsForm;
import cm.SelectAllCampus;
import cm.SelectAllCampusResultSet;
import cm.SelectAllColleges;
import cm.SelectAllCollegesResultSet;
import cm.SelectAllCurrics;
import cm.SelectAllCurricsResultSet;
import cm.SelectAllDepts;
import cm.SelectAllDeptsResultSet;
import cm.SelectCourseDetails;
import cm.SelectCourseDetailsResultSet;
import cm.UpdateCourse;
import martini.model.Handler;
import martini.model.Option;
import martini.model.Select;
import martini.runtime.RedirectException;
import martini.util.DB;

public class
	DetailsHandler
extends 
	Handler<Details>
{
	private DB _db = null;
	
	public void setDB( DB db )
	{
		_db = db;
	}
	
	public DB getDB()
	{
		return _db;
	}
	
	@Override
	public void GET( Details page, HttpServletRequest request, HttpServletResponse response )
		throws Exception
	{
		String dept = page.getDeptParam();
		String temp = page.getNumberParam();
		int number = Integer.parseInt( temp );
		String temp2 = page.getLastATPParam();
		int lastATP = Integer.parseInt( temp2 );

		DetailsDetailsForm form = page.getDetailsForm();

		Connection connection = getDB().getConnection();
		
		{
			SelectAllCampus select = new SelectAllCampus( connection );
			SelectAllCampusResultSet rs = select.execute();
			Select list = form.getCampus();
			list.getChildren().clear();
			while( rs.hasNext() )
			{
				Option option = new Option();
				option.setValue( rs.getId() );
				option.setText( rs.getName() );
				list.getChildren().add( option );
			}
		}
		
		{
			SelectAllColleges select = new SelectAllColleges( connection );
			SelectAllCollegesResultSet rs = select.execute();
			Select list = form.getCollege();
			list.getChildren().clear();
			while( rs.hasNext() )
			{
				Option option = new Option();
				option.setValue( rs.getId() );
				option.setText( rs.getName() );
				option.getAttributes().put( "data-campus", rs.getCampus() );
				list.getChildren().add( option );
			}
		}

		{
			SelectAllDepts select = new SelectAllDepts( connection );
			SelectAllDeptsResultSet rs = select.execute();
			Select list = form.getDept();
			list.getChildren().clear();
			while( rs.hasNext() )
			{
				Option option = new Option();
				option.setValue( rs.getId() );
				option.setText( rs.getDescr() );
				option.getAttributes().put( "data-college", rs.getCollege() );
				list.getChildren().add( option );
			}
		}
		
		{
			SelectAllCurrics select = new SelectAllCurrics( connection );
			SelectAllCurricsResultSet rs = select.execute();
			Select list = form.getCurric();
			list.getChildren().clear();
			while( rs.hasNext() )
			{
				Option option = new Option();
				option.setValue( rs.getId() );
				option.setText( rs.getDescr() );
				option.getAttributes().put( "data-dept", rs.getDept_id() );
				list.getChildren().add( option );
			}
		}

		
		SelectCourseDetails courseSelect = new SelectCourseDetails( connection );
		courseSelect.setDepartment_abbrev( dept );
		courseSelect.setCourse_number( number );
		courseSelect.setLastATP( lastATP );
		SelectCourseDetailsResultSet courseRS = courseSelect.execute();
		if( courseRS.hasNext() )
		{
			form.setId( courseRS.getId() );
			form.getCampus().setValue( Integer.toString( courseRS.getCourse_branch() ));
			form.getCollege().setValue( courseRS.getCourse_college() );
			form.getDept().setValue( courseRS.getDepartment_abbrev() );
			form.getCurric().setValue( courseRS.getDepartment_abbrev() );
			form.setNumber( courseRS.getCourse_number() );
			form.setCatalog( courseRS.getLong_course_title() );
			form.setTranscript( courseRS.getCourse_title() );
			form.setDescription( courseRS.getDescription() );
			form.setStartYear( courseRS.getFirstATP() );
			form.setEndYear( courseRS.getLastATP() );
			form.getCredits().setValue( Integer.toString( courseRS.getCredit_control() ));
			form.setCreditsMin( courseRS.getMin_qtr_credits() );
			form.setCreditsMax( courseRS.getMax_qtr_credits() );
			Select geneds = form.getGeneds();
			geneds.getOption( "DIV" ).setSelected( courseRS.getDiversity_crs() );
			geneds.getOption( "IS" ).setSelected( courseRS.getIndiv_society() );
			geneds.getOption( "NW" ).setSelected( courseRS.getNatural_world() );
			geneds.getOption( "VLPA" ).setSelected( courseRS.getVis_lit_perf_arts() );
			geneds.getOption( "WRITING" ).setSelected( courseRS.getWriting_crs() );
			geneds.getOption( "COMP" ).setSelected( courseRS.getEnglish_comp() );
			geneds.getOption( "QSR" ).setSelected( courseRS.getQsr() );
		}
	}
	
	@Override
	public void POST( Details page, HttpServletRequest request, HttpServletResponse response )
		throws Exception
	{
		DetailsDetailsForm form = page.getDetailsForm();
	
		Connection connection = getDB().getConnection();
		UpdateCourse update = new UpdateCourse();
		
		update.setIDParam( Long.parseLong( form.getId().toString() ));
		
		String campus = form.getCampus().getValue();
		update.setCourse_branch( Integer.parseInt( campus.toString() ));
		
		update.setDepartment_abbrev( form.getCurric().getValue() );
		try
		{
			String temp = form.getNumber().toString();
			update.setCourse_number( Integer.parseInt( temp ));
		} catch( Exception e ) {}
		update.setLong_course_title( form.getCatalog().toString() );
		update.setCourse_title( form.getTranscript().toString() );
		update.setDescription( form.getDescription().toString() );
		update.setFirstATP( Integer.parseInt( form.getStartYear( ).toString() ));
		update.setLastATP( Integer.parseInt( form.getEndYear( ).toString() ));
		update.setCredit_control( Integer.parseInt( form.getCredits().getValue() ));
		update.setMin_qtr_credits( Double.parseDouble( form.getCreditsMin( ).toString() ));
		update.setMax_qtr_credits( Double.parseDouble( form.getCreditsMax( ).toString() ));
		Select geneds = form.getGeneds();
		update.setDiversity_crs( geneds.getOption( "DIV" ).getSelected() );
		update.setIndiv_society( geneds.getOption( "IS" ).getSelected() );
		update.setNatural_world( geneds.getOption( "NW" ).getSelected() );
		update.setVis_lit_perf_arts( geneds.getOption( "VLPA" ).getSelected() );
		update.setWriting_crs( geneds.getOption( "WRITING" ).getSelected() );
		update.setEnglish_comp( geneds.getOption( "COMP" ).getSelected() );
		update.setQsr( geneds.getOption( "QSR" ).getSelected() );
		
		int count = update.execute( connection );
		if( count == 0 )
		{
			
		}
		else
		{	
			String uri = request.getRequestURI();
			throw new RedirectException( HttpServletResponse.SC_FOUND, uri );
		}
	}
}

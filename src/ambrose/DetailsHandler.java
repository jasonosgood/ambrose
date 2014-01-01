package ambrose;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ambrose.Details;
import ambrose.DetailsDetailsForm;
import cm.SelectCourseDetails;
import cm.SelectCourseDetailsResultSet;
import cm.UpdateCourse;
import martini.model.Handler;
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
		
		Connection connection = getDB().getConnection();
		SelectCourseDetails select = new SelectCourseDetails();
		select.setDepartment_abbrev( dept );
		select.setCourse_number( number );
		select.setLastATP( lastATP );
		SelectCourseDetailsResultSet rs = select.execute( connection );
		if( rs.hasNext() )
		{
			DetailsDetailsForm form = page.getDetailsForm();
			form.setId( rs.getId() );
			form.getCampus().setValue( Integer.toString( rs.getCourse_branch() ));
			form.setAbbrev( rs.getDepartment_abbrev() );
			form.setNumber( rs.getCourse_number() );
			form.setCatalog( rs.getLong_course_title() );
			form.setTranscript( rs.getCourse_title() );
			form.setDescription( rs.getDescription() );
			form.setStartYear( rs.getFirstATP() );
			form.setEndYear( rs.getLastATP() );
			form.getCredits().setValue( Integer.toString( rs.getCredit_control() ));
			form.setCreditsMin( rs.getMin_qtr_credits() );
			form.setCreditsMax( rs.getMax_qtr_credits() );
			form.setGened_is( rs.getIndiv_society() );
			form.setGened_nw( rs.getNatural_world() );
			form.setGened_vpla( rs.getVis_lit_perf_arts() );
			form.setGened_writing( rs.getWriting_crs() );
			form.setGened_div(rs.getDiversity_crs() );
			form.setGened_comp( rs.getEnglish_comp() );
			form.setGened_qsr( rs.getQsr() );
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
		
		update.setDepartment_abbrev( form.getAbbrev().toString() );
		update.setCourse_number( Integer.parseInt( form.getNumber().toString() ));
		update.setLong_course_title( form.getCatalog().toString() );
//		update.long_course_title = form.title;
		update.setCourse_title( form.getTranscript().toString() );
		update.setDescription( form.getDescription().toString() );
		update.setFirstATP( Integer.parseInt( form.getStartYear( ).toString() ));
		update.setLastATP( Integer.parseInt( form.getEndYear( ).toString() ));
		update.setCredit_control( Integer.parseInt( form.getCredits().getValue() ));
		update.setMin_qtr_credits( Double.parseDouble( form.getCreditsMin( ).toString() ));
		update.setMax_qtr_credits( Double.parseDouble( form.getCreditsMax( ).toString() ));
		update.setIndiv_society( form.getGened_is( ) );
		update.setNatural_world( form.getGened_nw( ) );
		update.setVis_lit_perf_arts( form.getGened_vpla( ) );
		update.setWriting_crs( form.getGened_writing( ) );
		update.setDiversity_crs( form.getGened_div() );
		update.setEnglish_comp( form.getGened_comp( ) );
		update.setQsr( form.getGened_qsr( ) );

		
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

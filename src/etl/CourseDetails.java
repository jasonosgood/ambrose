package etl;

import java.sql.Connection;

import cm.InsertCourse;
import martini.util.DB;
import uwsdb.SelectCourseDetails;
import uwsdb.SelectCourseDetailsResultSet;

public class 
	CourseDetails 
{

	public static void main( String[] args )
		throws Exception
	{
		DB uwsdb = new DB();
		uwsdb.setDriver( "net.sourceforge.jtds.jdbc.Driver" );
		uwsdb.setURL( "jdbc:jtds:sqlserver://ucssqlc1db1.admin.washington.edu:4358/UWSDBDataStore;ssl=require" );
		uwsdb.setUsername( "uw_oim_sis_ks" );
		uwsdb.setPassword( "k5mxb3m8" );
		Connection uwsdbConnection = uwsdb.getConnection();
		
		DB cm = new DB();
		cm.setDriver( "org.h2.Driver" );
		cm.setURL( "jdbc:h2:tcp://localhost/~/git/martini/db/cm" );
//		cm.setURL( "jdbc:h2:/Users/jasonosgood/git/martini/db/cm" );
		cm.setUsername( "sa" );
//		cm.setPassword( "k5mxb3m8" );
		Connection cmConnection = cm.getConnection();
		
		SelectCourseDetails select = new SelectCourseDetails();
		SelectCourseDetailsResultSet rs = select.execute( uwsdbConnection );
		
		InsertCourse insert = new InsertCourse();
		
		long start = System.currentTimeMillis();
		long count = 0;

		while( rs.hasNext() )
		{
			insert.setDepartment_abbrev( rs.getDepartment_abbrev() );
			insert.setCourse_number( rs.getCourse_number() );
			insert.setLong_course_title( rs.getLong_course_title() );
			insert.setCourse_title( rs.getCourse_title() );
			insert.setCourse_college( rs.getCourse_college() );
			insert.setCourse_branch( rs.getCourse_branch() );

			insert.setLastATP( rs.getLastATP() );
			insert.setFirstATP( rs.getFirstATP() );
			
			insert.setGrading_system( rs.getGrading_system() );
			insert.setCredit_control( rs.getCredit_control() );
			insert.setMin_qtr_credits( rs.getMin_qtr_credits().doubleValue() );
			insert.setMax_qtr_credits( rs.getMax_qtr_credits().doubleValue() );
			insert.setMax_credits( rs.getMax_credits().doubleValue() );
			
			
			insert.setApproved_dt( rs.getApproved_dt() );
			insert.setChanged_dt( rs.getChanged_dt() );
			insert.setDropped_dt( rs.getDropped_dt() );
			insert.setLast_update_dt( rs.getLast_update_dt() );
			insert.setSr_crs_dl_appr_dt( rs.getSr_crs_dl_appr_dt() );
			insert.setDeductible( rs.getDeductible() );
			insert.setHonors( rs.getHonors() );
			insert.setDup_enroll( rs.getDup_enroll() );
			insert.setCourse_ts_omit( rs.getCourse_ts_omit() );
			insert.setCourse_cat_omit( rs.getCourse_cat_omit() );
			
			insert.setWriting_crs( rs.getWriting_crs() );
			insert.setEnglish_comp( rs.getEnglish_comp() );
			insert.setQsr( rs.getQsr() );
			insert.setVis_lit_perf_arts( rs.getVis_lit_perf_arts() );
			insert.setIndiv_society( rs.getIndiv_society() );
			insert.setNatural_world( rs.getNatural_world() );
			insert.setDiversity_crs( rs.getDiversity_crs() );
			
			insert.setHyphen_type( rs.getHyphen_type() );
			insert.setPrior_dept_abbr( rs.getPrior_dept_abbr() );
			insert.setPrior_course_num( rs.getPrior_course_num() );

			insert.setResp_curric_abbr( rs.getResp_curric_abbr() );
			insert.setResp_course_no( rs.getResp_course_no() );
			insert.execute( cmConnection );
			count++;
			
			if(( count % 100 ) == 0 )
			{
				System.out.printf( "\ncount: %d ", count);
			}

		}
		long elapsed = ( System.currentTimeMillis() - start ) / 1000;
		System.out.printf( "\ncount: %d\n", count );
		System.out.printf( "elapsed: %d\n", elapsed );

		
		rs.close();
		uwsdbConnection.close();
		cmConnection.close();

	}

}

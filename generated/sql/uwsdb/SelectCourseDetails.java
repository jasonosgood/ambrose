/**

SelectCourseDetails.java   Fri Dec 06 11:33:38 PST 2013
  
Generated using Fado's Select.vm template. Original SQL:
    
SELECT
	department_abbrev,
	course_number,
	long_course_title,
	course_title,
	course_college,
	course_branch,
	
	-- atp
	( last_eff_yr * 10 ) + last_eff_qtr as lastATP,
	( first_eff_yr * 10 ) + first_eff_qtr as firstATP,
	
	grading_system,
	credit_control,
	min_qtr_credits,
	max_qtr_credits,
	max_credits,
	
	
	approved_dt,
	changed_dt,
	dropped_dt,
	last_update_dt,
	sr_crs_dl_appr_dt,
	deductible,
	honors,
	dup_enroll,
	course_ts_omit,
	course_cat_omit,
	
	-- gened reqs
	writing_crs,
	english_comp,
	qsr,
	vis_lit_perf_arts,
	indiv_society,
	natural_world,
	diversity_crs,
	
	-- course sequence
	hyphen_type,
	prior_dept_abbr,
	prior_course_num,

	resp_curric_abbr,
	resp_course_no
	
FROM 
	sr_course_titles
WHERE 
(
	( last_eff_yr * 10 ) + last_eff_qtr < 20134
	OR ( department_abbrev = resp_curric_abbr AND course_number = resp_course_no )
	OR resp_course_no = 0
)
ORDER BY 
	department_abbrev, 
	course_number, 
	first_eff_yr, 
	first_eff_qtr

@see ./SelectCourseDetails.sql
  

**/

package uwsdb;

import java.sql.*;
import javax.sql.DataSource;
import java.math.BigDecimal;

public class 
	SelectCourseDetails
{
	private int __resultSetType = ResultSet.TYPE_SCROLL_INSENSITIVE;
	
	public void setResultSetType( int resultSetType )
	{
		__resultSetType = resultSetType;
	}
	
	public int getResultSetType()
	{
		return __resultSetType;
	}
	
	private int __resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;

	public void setResultSetConcurrency( int resultSetConcurrency )
	{
		__resultSetConcurrency = resultSetConcurrency;
	}
	
	public int getResultSetConcurrency()
	{
		return __resultSetConcurrency;
	}
	

	/**
		Pass a Connection instance, you are responsible for closing it, method SelectCourseDetailsResultSet.close()
		WILL NOT call that instance's Connection.close() method. 
		 
	**/
	public final SelectCourseDetailsResultSet execute( Connection connection )
		throws SQLException
	{
		String sql = getSQL();
		PreparedStatement ps = connection.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			
			
		ResultSet rs = null;
		if( ps.execute() )
		{
			rs = ps.getResultSet();
		}
		SelectCourseDetailsResultSet result = new SelectCourseDetailsResultSet( rs );
		return result;
	}

	/**
		Pass a DataSource, a Connection instance is created, method SelectCourseDetailsResultSet.close() WILL 
		also call that instance's Connection.close() method. 
	**/
	public final SelectCourseDetailsResultSet execute( DataSource dataSource )
		throws SQLException
	{
		Connection connection = dataSource.getConnection();
		SelectCourseDetailsResultSet result = execute( connection );
		result.setConnection( connection );
		return result;
	}



	private static String __sql = null;
	
	public String getSQL()
	{
		if( __sql == null )
		{
			StringBuilder sb = new StringBuilder();
			sb.append( "SELECT" );
			sb.append( '\n' );
			sb.append( "	department_abbrev," );
			sb.append( '\n' );
			sb.append( "	course_number," );
			sb.append( '\n' );
			sb.append( "	long_course_title," );
			sb.append( '\n' );
			sb.append( "	course_title," );
			sb.append( '\n' );
			sb.append( "	course_college," );
			sb.append( '\n' );
			sb.append( "	course_branch," );
			sb.append( '\n' );
			sb.append( "	" );
			sb.append( '\n' );
			sb.append( "	-- atp" );
			sb.append( '\n' );
			sb.append( "	( last_eff_yr * 10 ) + last_eff_qtr as lastATP," );
			sb.append( '\n' );
			sb.append( "	( first_eff_yr * 10 ) + first_eff_qtr as firstATP," );
			sb.append( '\n' );
			sb.append( "	" );
			sb.append( '\n' );
			sb.append( "	grading_system," );
			sb.append( '\n' );
			sb.append( "	credit_control," );
			sb.append( '\n' );
			sb.append( "	min_qtr_credits," );
			sb.append( '\n' );
			sb.append( "	max_qtr_credits," );
			sb.append( '\n' );
			sb.append( "	max_credits," );
			sb.append( '\n' );
			sb.append( "	" );
			sb.append( '\n' );
			sb.append( "	" );
			sb.append( '\n' );
			sb.append( "	approved_dt," );
			sb.append( '\n' );
			sb.append( "	changed_dt," );
			sb.append( '\n' );
			sb.append( "	dropped_dt," );
			sb.append( '\n' );
			sb.append( "	last_update_dt," );
			sb.append( '\n' );
			sb.append( "	sr_crs_dl_appr_dt," );
			sb.append( '\n' );
			sb.append( "	deductible," );
			sb.append( '\n' );
			sb.append( "	honors," );
			sb.append( '\n' );
			sb.append( "	dup_enroll," );
			sb.append( '\n' );
			sb.append( "	course_ts_omit," );
			sb.append( '\n' );
			sb.append( "	course_cat_omit," );
			sb.append( '\n' );
			sb.append( "	" );
			sb.append( '\n' );
			sb.append( "	-- gened reqs" );
			sb.append( '\n' );
			sb.append( "	writing_crs," );
			sb.append( '\n' );
			sb.append( "	english_comp," );
			sb.append( '\n' );
			sb.append( "	qsr," );
			sb.append( '\n' );
			sb.append( "	vis_lit_perf_arts," );
			sb.append( '\n' );
			sb.append( "	indiv_society," );
			sb.append( '\n' );
			sb.append( "	natural_world," );
			sb.append( '\n' );
			sb.append( "	diversity_crs," );
			sb.append( '\n' );
			sb.append( "	" );
			sb.append( '\n' );
			sb.append( "	-- course sequence" );
			sb.append( '\n' );
			sb.append( "	hyphen_type," );
			sb.append( '\n' );
			sb.append( "	prior_dept_abbr," );
			sb.append( '\n' );
			sb.append( "	prior_course_num," );
			sb.append( '\n' );
			sb.append( "" );
			sb.append( '\n' );
			sb.append( "	resp_curric_abbr," );
			sb.append( '\n' );
			sb.append( "	resp_course_no" );
			sb.append( '\n' );
			sb.append( "	" );
			sb.append( '\n' );
			sb.append( "FROM " );
			sb.append( '\n' );
			sb.append( "	sr_course_titles" );
			sb.append( '\n' );
			sb.append( "WHERE " );
			sb.append( '\n' );
			sb.append( "(" );
			sb.append( '\n' );
			sb.append( "	( last_eff_yr * 10 ) + last_eff_qtr < 20134" );
			sb.append( '\n' );
			sb.append( "	OR ( department_abbrev = resp_curric_abbr AND course_number = resp_course_no )" );
			sb.append( '\n' );
			sb.append( "	OR resp_course_no = 0" );
			sb.append( '\n' );
			sb.append( ")" );
			sb.append( '\n' );
			sb.append( "ORDER BY " );
			sb.append( '\n' );
			sb.append( "	department_abbrev, " );
			sb.append( '\n' );
			sb.append( "	course_number, " );
			sb.append( '\n' );
			sb.append( "	first_eff_yr, " );
			sb.append( '\n' );
			sb.append( "	first_eff_qtr" );
			sb.append( '\n' );
			__sql = sb.toString();
		}
		return __sql;
	}
	
	public String toString()
	{
		String result = getSQL();
		return result;
	}
	
	private String quotifyString( Object value )
	{
		if( value instanceof String )
		{
			return "'" + value.toString() + "'";
		}
		else
		{
			return value.toString();
		}
	}

}

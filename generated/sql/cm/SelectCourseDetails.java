/**

SelectCourseDetails.java   Tue Dec 10 10:42:52 PST 2013
  
Generated using Fado's Select.vm template. Original SQL:
    
SELECT
	id,
	department_abbrev,
	course_number,
	long_course_title,
	course_title,
	description,
	course_college,
	course_branch,
	lastATP,
	firstATP,
	
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
	diversity_crs
FROM  Course
WHERE lastATP = 99994
AND   department_abbrev = 'ENGL' 
AND   course_number = '100'

@see ./SelectCourseDetails.sql
  

**/

package cm;

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
			
		ps.setInt( 1, getLastATP() );
		ps.setString( 2, getDepartment_abbrev() );
		ps.setInt( 3, getCourse_number() );
			
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



	public int _lastATP = 99994;
	
	public void setLastATP( int lastATP )
	{
		_lastATP = lastATP;
	}
	
	public int getLastATP()
	{
		return _lastATP;
	}


	public java.lang.String _department_abbrev = "ENGL";
	
	public void setDepartment_abbrev( java.lang.String department_abbrev )
	{
		_department_abbrev = department_abbrev;
	}
	
	public java.lang.String getDepartment_abbrev()
	{
		return _department_abbrev;
	}


	public int _course_number = 100;
	
	public void setCourse_number( int course_number )
	{
		_course_number = course_number;
	}
	
	public int getCourse_number()
	{
		return _course_number;
	}


	private static String __sql = null;
	
	public String getSQL()
	{
		if( __sql == null )
		{
			StringBuilder sb = new StringBuilder();
			sb.append( "SELECT" );
			sb.append( '\n' );
			sb.append( "	id," );
			sb.append( '\n' );
			sb.append( "	department_abbrev," );
			sb.append( '\n' );
			sb.append( "	course_number," );
			sb.append( '\n' );
			sb.append( "	long_course_title," );
			sb.append( '\n' );
			sb.append( "	course_title," );
			sb.append( '\n' );
			sb.append( "	description," );
			sb.append( '\n' );
			sb.append( "	course_college," );
			sb.append( '\n' );
			sb.append( "	course_branch," );
			sb.append( '\n' );
			sb.append( "	lastATP," );
			sb.append( '\n' );
			sb.append( "	firstATP," );
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
			sb.append( "	diversity_crs" );
			sb.append( '\n' );
			sb.append( "FROM  Course" );
			sb.append( '\n' );
			sb.append( "WHERE lastATP = ?" );
			sb.append( '\n' );
			sb.append( "AND   department_abbrev = ? " );
			sb.append( '\n' );
			sb.append( "AND   course_number = ?" );
			sb.append( '\n' );
			__sql = sb.toString();
		}
		return __sql;
	}
	
	public String toString()
	{
		String result = getSQL();
		result = result.replaceFirst( "\\?", quotifyString( getLastATP() ));
		result = result.replaceFirst( "\\?", quotifyString( getDepartment_abbrev() ));
		result = result.replaceFirst( "\\?", quotifyString( getCourse_number() ));
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

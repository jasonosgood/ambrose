/**

SelectJointCourses.java   Fri Dec 06 11:33:38 PST 2013
  
Generated using Fado's Select.vm template. Original SQL:
    
SELECT
	joint_dept_abbrev,
	joint_course_num,
	( last_eff_yr * 10 ) + last_eff_qtr as lastATP
FROM sr_course_titles_joint_course
WHERE department_abbrev = 'E E   '
AND course_number = 510
AND ( last_eff_yr * 10 ) + last_eff_qtr >= 20134

@see ./SelectJointCourses.sql
  

**/

package uwsdb;

import java.sql.*;
import javax.sql.DataSource;
import java.math.BigDecimal;

public class 
	SelectJointCourses
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
		Pass a Connection instance, you are responsible for closing it, method SelectJointCoursesResultSet.close()
		WILL NOT call that instance's Connection.close() method. 
		 
	**/
	public final SelectJointCoursesResultSet execute( Connection connection )
		throws SQLException
	{
		String sql = getSQL();
		PreparedStatement ps = connection.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			
		ps.setString( 1, getDepartment_abbrev() );
		ps.setShort( 2, getCourse_number() );
			
		ResultSet rs = null;
		if( ps.execute() )
		{
			rs = ps.getResultSet();
		}
		SelectJointCoursesResultSet result = new SelectJointCoursesResultSet( rs );
		return result;
	}

	/**
		Pass a DataSource, a Connection instance is created, method SelectJointCoursesResultSet.close() WILL 
		also call that instance's Connection.close() method. 
	**/
	public final SelectJointCoursesResultSet execute( DataSource dataSource )
		throws SQLException
	{
		Connection connection = dataSource.getConnection();
		SelectJointCoursesResultSet result = execute( connection );
		result.setConnection( connection );
		return result;
	}



	public java.lang.String _department_abbrev = "E E   ";
	
	public void setDepartment_abbrev( java.lang.String department_abbrev )
	{
		_department_abbrev = department_abbrev;
	}
	
	public java.lang.String getDepartment_abbrev()
	{
		return _department_abbrev;
	}


	public short _course_number = (short) 510;
	
	public void setCourse_number( short course_number )
	{
		_course_number = course_number;
	}
	
	public short getCourse_number()
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
			sb.append( "	joint_dept_abbrev," );
			sb.append( '\n' );
			sb.append( "	joint_course_num," );
			sb.append( '\n' );
			sb.append( "	( last_eff_yr * 10 ) + last_eff_qtr as lastATP" );
			sb.append( '\n' );
			sb.append( "FROM sr_course_titles_joint_course" );
			sb.append( '\n' );
			sb.append( "WHERE department_abbrev = ?" );
			sb.append( '\n' );
			sb.append( "AND course_number = ?" );
			sb.append( '\n' );
			sb.append( "AND ( last_eff_yr * 10 ) + last_eff_qtr >= 20134" );
			sb.append( '\n' );
			__sql = sb.toString();
		}
		return __sql;
	}
	
	public String toString()
	{
		String result = getSQL();
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

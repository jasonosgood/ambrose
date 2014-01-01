/**

SelectCourseDescr.java   Tue Dec 10 10:42:51 PST 2013
  
Generated using Fado's Select.vm template. Original SQL:
    
SELECT 
id, lastATP, course_title, description, revision
FROM Course
WHERE department_abbrev = 'ENGL' 
AND  course_number = '100'
ORDER BY lastATP desc;

@see ./SelectCourseDescr.sql
  

**/

package cm;

import java.sql.*;
import javax.sql.DataSource;
import java.math.BigDecimal;

public class 
	SelectCourseDescr
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
		Pass a Connection instance, you are responsible for closing it, method SelectCourseDescrResultSet.close()
		WILL NOT call that instance's Connection.close() method. 
		 
	**/
	public final SelectCourseDescrResultSet execute( Connection connection )
		throws SQLException
	{
		String sql = getSQL();
		PreparedStatement ps = connection.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			
		ps.setString( 1, getDepartment_abbrev() );
		ps.setInt( 2, getCourse_number() );
			
		ResultSet rs = null;
		if( ps.execute() )
		{
			rs = ps.getResultSet();
		}
		SelectCourseDescrResultSet result = new SelectCourseDescrResultSet( rs );
		return result;
	}

	/**
		Pass a DataSource, a Connection instance is created, method SelectCourseDescrResultSet.close() WILL 
		also call that instance's Connection.close() method. 
	**/
	public final SelectCourseDescrResultSet execute( DataSource dataSource )
		throws SQLException
	{
		Connection connection = dataSource.getConnection();
		SelectCourseDescrResultSet result = execute( connection );
		result.setConnection( connection );
		return result;
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
			sb.append( "SELECT " );
			sb.append( '\n' );
			sb.append( "id, lastATP, course_title, description, revision" );
			sb.append( '\n' );
			sb.append( "FROM Course" );
			sb.append( '\n' );
			sb.append( "WHERE department_abbrev = ? " );
			sb.append( '\n' );
			sb.append( "AND  course_number = ?" );
			sb.append( '\n' );
			sb.append( "ORDER BY lastATP desc;" );
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

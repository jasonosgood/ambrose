/**

SelectCourseDescr.java   Wed Jul 30 06:47:32 PDT 2014
  
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
	PreparedStatement __ps = null;

	/**
		Pass a Connection. You are responsible for closing that Connection. 
		SelectCourseDescr is a wrapper for a PreparedStatement, not a Connection.
	**/
	public SelectCourseDescr( Connection connection, int resultSetType, int resultSetConcurrency )
		throws SQLException
	{
		String sql = getSQL();
		__ps = connection.prepareStatement( sql, resultSetType, resultSetConcurrency );
	}

	public SelectCourseDescr( Connection connection )
		throws SQLException
	{
		this( connection, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
	}
	
	/**
		Pass a DataSource. You are responsible for closing that DataSource. 
		SelectCourseDescr is a wrapper for a PreparedStatement, not a Connection.
	**/
	public SelectCourseDescr( DataSource dataSource, int resultSetType, int resultSetConcurrency )
		throws SQLException
	{
		this( dataSource.getConnection(), resultSetType, resultSetConcurrency );
	}

	public SelectCourseDescr( DataSource dataSource )
		throws SQLException
	{
		this( dataSource, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
	}
		
	public final SelectCourseDescrResultSet execute()
		throws SQLException
	{
		__ps.setString( 1, getDepartment_abbrev() );
		__ps.setInt( 2, getCourse_number() );
			
		ResultSet rs = null;
		if( __ps.execute() )
		{
			rs = __ps.getResultSet();
		}
		SelectCourseDescrResultSet result = new SelectCourseDescrResultSet( rs );
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

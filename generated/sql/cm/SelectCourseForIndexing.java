/**

SelectCourseForIndexing.java   Wed Jul 30 06:47:32 PDT 2014
  
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
	firstATP
FROM Course
WHERE lastATP = 99994

@see ./SelectCourseForIndexing.sql
  

**/

package cm;

import java.sql.*;
import javax.sql.DataSource;
import java.math.BigDecimal;

public class 
	SelectCourseForIndexing
{
	PreparedStatement __ps = null;

	/**
		Pass a Connection. You are responsible for closing that Connection. 
		SelectCourseForIndexing is a wrapper for a PreparedStatement, not a Connection.
	**/
	public SelectCourseForIndexing( Connection connection, int resultSetType, int resultSetConcurrency )
		throws SQLException
	{
		String sql = getSQL();
		__ps = connection.prepareStatement( sql, resultSetType, resultSetConcurrency );
	}

	public SelectCourseForIndexing( Connection connection )
		throws SQLException
	{
		this( connection, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
	}
	
	/**
		Pass a DataSource. You are responsible for closing that DataSource. 
		SelectCourseForIndexing is a wrapper for a PreparedStatement, not a Connection.
	**/
	public SelectCourseForIndexing( DataSource dataSource, int resultSetType, int resultSetConcurrency )
		throws SQLException
	{
		this( dataSource.getConnection(), resultSetType, resultSetConcurrency );
	}

	public SelectCourseForIndexing( DataSource dataSource )
		throws SQLException
	{
		this( dataSource, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
	}
		
	public final SelectCourseForIndexingResultSet execute()
		throws SQLException
	{
		__ps.setInt( 1, getLastATP() );
			
		ResultSet rs = null;
		if( __ps.execute() )
		{
			rs = __ps.getResultSet();
		}
		SelectCourseForIndexingResultSet result = new SelectCourseForIndexingResultSet( rs );
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
			sb.append( "	firstATP" );
			sb.append( '\n' );
			sb.append( "FROM Course" );
			sb.append( '\n' );
			sb.append( "WHERE lastATP = ?" );
			sb.append( '\n' );
			__sql = sb.toString();
		}
		return __sql;
	}
	
	public String toString()
	{
		String result = getSQL();
		result = result.replaceFirst( "\\?", quotifyString( getLastATP() ));
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

/**

SelectCourseForIndexing.java   Tue Dec 10 10:42:52 PST 2013
  
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
		Pass a Connection instance, you are responsible for closing it, method SelectCourseForIndexingResultSet.close()
		WILL NOT call that instance's Connection.close() method. 
		 
	**/
	public final SelectCourseForIndexingResultSet execute( Connection connection )
		throws SQLException
	{
		String sql = getSQL();
		PreparedStatement ps = connection.prepareStatement( sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
			
		ps.setInt( 1, getLastATP() );
			
		ResultSet rs = null;
		if( ps.execute() )
		{
			rs = ps.getResultSet();
		}
		SelectCourseForIndexingResultSet result = new SelectCourseForIndexingResultSet( rs );
		return result;
	}

	/**
		Pass a DataSource, a Connection instance is created, method SelectCourseForIndexingResultSet.close() WILL 
		also call that instance's Connection.close() method. 
	**/
	public final SelectCourseForIndexingResultSet execute( DataSource dataSource )
		throws SQLException
	{
		Connection connection = dataSource.getConnection();
		SelectCourseForIndexingResultSet result = execute( connection );
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

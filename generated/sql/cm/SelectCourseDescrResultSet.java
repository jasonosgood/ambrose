/**

SelectCourseDescrResultSet.java   Wed Jul 30 06:47:32 PDT 2014
  
Generated using Fado's ResultSet.vm template. Original SQL:
    
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
import java.math.BigDecimal;

public class 
	SelectCourseDescrResultSet
{
	private ResultSet __resultSet = null;

	public SelectCourseDescrResultSet( ResultSet resultSet )
	{
		__resultSet = resultSet;
	}

	public final ResultSet getResultSet()
	{
		return __resultSet;
	}
	
	public boolean getSuccess()
	{
		return __resultSet != null;
	}
	
	/**
		Closes the contained ResultSet instance. Also closes contained Connection instance 
		created via a DataSource connection factory.
	**/
	public void close()
		throws SQLException
	{
		if( __resultSet != null )
		{
			__resultSet.close();
			__resultSet = null;
		}
		Connection connection = getConnection();
		if( connection != null )
		{
			connection.close();
		}
	}

	
	private Connection __connection = null;
	
	public void setConnection( Connection connection )
	{
		__connection = connection;
	}
	
	public Connection getConnection()
	{
		return __connection;
	}
	
	
	public final boolean hasNext()
		throws SQLException
	{
		ResultSet rs = getResultSet();
		if( rs == null ) return false;
		boolean	success = rs.next();
		if( success )
		{
			_id = rs.getLong( 1 );
			_lastATP = rs.getInt( 2 );
			_course_title = rs.getString( 3 );
			_course_title_has = !rs.wasNull();
			_description = rs.getString( 4 );
			_description_has = !rs.wasNull();
			_revision = rs.getLong( 5 );
		}
		return success;
	}
	
	public int count()
	{
		int result = 0;
		try
		{
			ResultSet rs = getResultSet();
			int current = rs.getRow();
			if( rs.last() )
			{
				result = rs.getRow();
				if( current == 0 )
				{
					rs.beforeFirst();
				}
				else
				{
					rs.absolute( current );
				}
			}
				
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}
		return result;
	}
	
	private long _id = 0L;

	/** id **/
	public long getId()
	{
		return _id;
	}	

	private int _lastATP = 0;

	/** lastATP **/
	public int getLastATP()
	{
		return _lastATP;
	}	

	private java.lang.String _course_title = null;

	/** course_title **/
	public java.lang.String getCourse_title()
	{
		return _course_title;
	}	

	private boolean _course_title_has = false;
	
	/** returns true if course_title is non-null **/
	public boolean hasCourse_title()
	{
		return _course_title_has;
	}	
	
	private String _description = null;

	/** description **/
	public String getDescription()
	{
		return _description;
	}	

	private boolean _description_has = false;
	
	/** returns true if description is non-null **/
	public boolean hasDescription()
	{
		return _description_has;
	}	
	
	private long _revision = 0L;

	/** revision **/
	public long getRevision()
	{
		return _revision;
	}	


	public String toString()
	{
		if( getResultSet() == null )
		{
			return "No results";
		}
		StringBuilder sb = new StringBuilder();
		sb.append( "Id: " );
		sb.append( getId() );
		sb.append( "\n" );
		sb.append( "LastATP: " );
		sb.append( getLastATP() );
		sb.append( "\n" );
		sb.append( "Course_title: " );
		sb.append( getCourse_title() );
		sb.append( "\n" );
		sb.append( "Description: " );
		sb.append( getDescription() );
		sb.append( "\n" );
		sb.append( "Revision: " );
		sb.append( getRevision() );
		sb.append( "\n" );
		return sb.toString();
	}
}

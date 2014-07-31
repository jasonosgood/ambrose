/**

SelectCourseForIndexingResultSet.java   Wed Jul 30 06:47:32 PDT 2014
  
Generated using Fado's ResultSet.vm template. Original SQL:
    
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
import java.math.BigDecimal;

public class 
	SelectCourseForIndexingResultSet
{
	private ResultSet __resultSet = null;

	public SelectCourseForIndexingResultSet( ResultSet resultSet )
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
			_department_abbrev = rs.getString( 2 );
			_course_number = rs.getInt( 3 );
			_long_course_title = rs.getString( 4 );
			_long_course_title_has = !rs.wasNull();
			_course_title = rs.getString( 5 );
			_course_title_has = !rs.wasNull();
			_description = rs.getString( 6 );
			_description_has = !rs.wasNull();
			_course_college = rs.getString( 7 );
			_course_branch = rs.getInt( 8 );
			_lastATP = rs.getInt( 9 );
			_firstATP = rs.getInt( 10 );
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

	private java.lang.String _department_abbrev = null;

	/** department_abbrev **/
	public java.lang.String getDepartment_abbrev()
	{
		return _department_abbrev;
	}	

	private int _course_number = 0;

	/** course_number **/
	public int getCourse_number()
	{
		return _course_number;
	}	

	private java.lang.String _long_course_title = null;

	/** long_course_title **/
	public java.lang.String getLong_course_title()
	{
		return _long_course_title;
	}	

	private boolean _long_course_title_has = false;
	
	/** returns true if long_course_title is non-null **/
	public boolean hasLong_course_title()
	{
		return _long_course_title_has;
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
	
	private java.lang.String _course_college = null;

	/** course_college **/
	public java.lang.String getCourse_college()
	{
		return _course_college;
	}	

	private int _course_branch = 0;

	/** course_branch **/
	public int getCourse_branch()
	{
		return _course_branch;
	}	

	private int _lastATP = 0;

	/** lastATP **/
	public int getLastATP()
	{
		return _lastATP;
	}	

	private int _firstATP = 0;

	/** firstATP **/
	public int getFirstATP()
	{
		return _firstATP;
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
		sb.append( "Department_abbrev: " );
		sb.append( getDepartment_abbrev() );
		sb.append( "\n" );
		sb.append( "Course_number: " );
		sb.append( getCourse_number() );
		sb.append( "\n" );
		sb.append( "Long_course_title: " );
		sb.append( getLong_course_title() );
		sb.append( "\n" );
		sb.append( "Course_title: " );
		sb.append( getCourse_title() );
		sb.append( "\n" );
		sb.append( "Description: " );
		sb.append( getDescription() );
		sb.append( "\n" );
		sb.append( "Course_college: " );
		sb.append( getCourse_college() );
		sb.append( "\n" );
		sb.append( "Course_branch: " );
		sb.append( getCourse_branch() );
		sb.append( "\n" );
		sb.append( "LastATP: " );
		sb.append( getLastATP() );
		sb.append( "\n" );
		sb.append( "FirstATP: " );
		sb.append( getFirstATP() );
		sb.append( "\n" );
		return sb.toString();
	}
}

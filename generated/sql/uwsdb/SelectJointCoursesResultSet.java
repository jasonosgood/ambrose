/**

SelectJointCoursesResultSet.java   Fri Dec 06 11:33:38 PST 2013
  
Generated using Fado's ResultSet.vm template. Original SQL:
    
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
import java.math.BigDecimal;

public class 
	SelectJointCoursesResultSet
{
	private ResultSet __resultSet = null;

	public SelectJointCoursesResultSet( ResultSet resultSet )
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
			_joint_dept_abbrev = rs.getString( 1 );
			_joint_dept_abbrev_has = !rs.wasNull();
			_joint_course_num = rs.getShort( 2 );
			_joint_course_num_has = !rs.wasNull();
			_lastATP = rs.getInt( 3 );
			_lastATP_has = !rs.wasNull();
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
	
	private java.lang.String _joint_dept_abbrev = null;

	/** joint_dept_abbrev **/
	public java.lang.String getJoint_dept_abbrev()
	{
		return _joint_dept_abbrev;
	}	

	private boolean _joint_dept_abbrev_has = false;
	
	/** returns true if joint_dept_abbrev is non-null **/
	public boolean hasJoint_dept_abbrev()
	{
		return _joint_dept_abbrev_has;
	}	
	
	private short _joint_course_num = 0;

	/** joint_course_num **/
	public short getJoint_course_num()
	{
		return _joint_course_num;
	}	

	private boolean _joint_course_num_has = false;
	
	/** returns true if joint_course_num is non-null **/
	public boolean hasJoint_course_num()
	{
		return _joint_course_num_has;
	}	
	
	private int _lastATP = 0;

	/** lastATP **/
	public int getLastATP()
	{
		return _lastATP;
	}	

	private boolean _lastATP_has = false;
	
	/** returns true if lastATP is non-null **/
	public boolean hasLastATP()
	{
		return _lastATP_has;
	}	
	

	public String toString()
	{
		if( getResultSet() == null )
		{
			return "No results";
		}
		StringBuilder sb = new StringBuilder();
		sb.append( "Joint_dept_abbrev: " );
		sb.append( getJoint_dept_abbrev() );
		sb.append( "\n" );
		sb.append( "Joint_course_num: " );
		sb.append( getJoint_course_num() );
		sb.append( "\n" );
		sb.append( "LastATP: " );
		sb.append( getLastATP() );
		sb.append( "\n" );
		return sb.toString();
	}
}

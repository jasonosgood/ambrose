
/**

UpdateCourseDescr.java   Tue Dec 10 10:42:52 PST 2013
  
Generated using Fado's Update.vm template. Original SQL:
    
UPDATE Course SET
description = 'argh',
revision = 1
WHERE id = 19462
AND revision = 0

@see ./UpdateCourseDescr.sql
  
**/

package cm;

import java.sql.*;
import javax.sql.DataSource;
import java.math.BigDecimal;

public class 
	UpdateCourseDescr
{

	/**
		Pass a DataSource, a Connection instance is created, call its close() method when done. 
	**/
	public final int execute( DataSource dataSource )
		throws SQLException
	{
		Connection connection = dataSource.getConnection();
		int rows = execute( connection );
		connection.close();
		return rows;
	}

	public final int execute( Connection connection )
		throws SQLException
	{
		String sql = getSQL();
		PreparedStatement ps = connection.prepareStatement( sql );
		
		
		ps.setString( 1, getDescription() );
		ps.setLong( 2, getRevision() );
		ps.setLong( 3, getIdParam() );
		ps.setLong( 4, getRevisionParam() );
		int rows = ps.executeUpdate();
		return rows;
	}
	
	
	
	private String _description = "argh";
	private long _revision = 1L;

	public void setDescription( String description )
	{
		_description = description;
	}
	
	public String getDescription()
	{
		return _description;
	}	

	public void setRevision( long revision )
	{
		_revision = revision;
	}
	
	public long getRevision()
	{
		return _revision;
	}	



	public long _idParam = 19462L;
	
	public void setIdParam( long id )
	{
		_idParam = id;
	}
	
	public long getIdParam()
	{
		return _idParam;
	}


	public long _revisionParam = 0L;
	
	public void setRevisionParam( long revision )
	{
		_revisionParam = revision;
	}
	
	public long getRevisionParam()
	{
		return _revisionParam;
	}

	
	private static String __sql = null;

	public String getSQL()
	{
		if( __sql == null )
		{
			StringBuilder sb = new StringBuilder();
			sb.append( "UPDATE Course SET" );
			sb.append( '\n' );
			sb.append( "description = ?," );
			sb.append( '\n' );
			sb.append( "revision = ?" );
			sb.append( '\n' );
			sb.append( "WHERE id = ?" );
			sb.append( '\n' );
			sb.append( "AND revision = ?" );
			sb.append( '\n' );
			__sql = sb.toString();
		}
		return __sql;
	}
	
	public String toString()
	{
		String result = getSQL();
		result = result.replaceFirst( "\\?", quotifyString( getDescription() ));
		result = result.replaceFirst( "\\?", quotifyString( getRevision() ));
		result = result.replaceFirst( "\\?", quotifyString( getIdParam() ));
		result = result.replaceFirst( "\\?", quotifyString( getRevisionParam() ));
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

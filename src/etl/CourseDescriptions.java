package etl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;

import martini.util.DB;

import org.h2.tools.Csv;

import cm.SelectCourseDescr;
import cm.SelectCourseDescrResultSet;
import cm.UpdateCourseDescr;

public class 
	CourseDescriptions 
{

	public static void main( String[] args )
		throws Exception
	{
		DB cm = new DB();
		cm.setDriver( "org.h2.Driver" );
		cm.setURL( "jdbc:h2:tcp://localhost/~/git/martini/db/cm" );
		cm.setUsername( "sa" );
		Connection cmConnection = cm.getConnection();

		SelectCourseDescr select = new SelectCourseDescr();
		UpdateCourseDescr update = new UpdateCourseDescr();
		
		Csv haha = Csv.getInstance();
		haha.setFieldSeparatorRead( '|' );
		String file = "/Users/jasonosgood/Projects/workspace/school/data/crspipedel_crlf_20131014.txt";
		FileReader reader = new FileReader( file );
		ResultSet rs = haha.read( reader, null );
		
		long start = System.currentTimeMillis();
		long count = 0;

		while( rs.next() )
		{
			String abbrev = rs.getString( 2 );
			String temp = rs.getString( 3 );
			int num = Integer.parseInt( temp );
			String title = rs.getString( 4 );
			String desc = rs.getString( 5 );
//			System.out.printf( "%s %s %s\n", abbrev, temp, desc );
			
			select.setDepartment_abbrev( abbrev );
			select.setCourse_number( num );
			SelectCourseDescrResultSet courseRS = select.execute( cmConnection );
			if( courseRS.hasNext() )
			{
				String old = courseRS.getDescription();
				if( old != null && old.equals( desc )) continue;
				
				long id = courseRS.getId();
				long revision = courseRS.getRevision();
				update.setDescription( desc );
				update.setRevision( revision + 1 );
				update.setIdParam(id);
				update.setRevisionParam(revision);
				update.execute(cmConnection);
				
			}
			courseRS.close();
			count++;
			
			if(( count % 100 ) == 0 )
			{
				System.out.printf( "\ncount: %d ", count );
			}

			
		}
		
		long elapsed = ( System.currentTimeMillis() - start ) / 1000;
		System.out.printf( "\ncount: %d\n", count );
		System.out.printf( "elapsed: %d\n", elapsed );

	}

}

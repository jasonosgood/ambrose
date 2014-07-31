/**

SelectCourseDetailsResultSet.java   Wed Jul 30 06:47:32 PDT 2014
  
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
	firstATP,
	
	grading_system,
	credit_control,
	min_qtr_credits,
	max_qtr_credits,
	max_credits,
	
	
	approved_dt,
	changed_dt,
	dropped_dt,
	last_update_dt,
	sr_crs_dl_appr_dt,
	deductible,
	honors,
	dup_enroll,
	course_ts_omit,
	course_cat_omit,
	
	-- gened reqs
	writing_crs,
	english_comp,
	qsr,
	vis_lit_perf_arts,
	indiv_society,
	natural_world,
	diversity_crs
FROM  Course
WHERE lastATP = 99994
AND   department_abbrev = 'ENGL' 
AND   course_number = '100'

@see ./SelectCourseDetails.sql
  

**/

package cm;

import java.sql.*;
import java.math.BigDecimal;

public class 
	SelectCourseDetailsResultSet
{
	private ResultSet __resultSet = null;

	public SelectCourseDetailsResultSet( ResultSet resultSet )
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
			_grading_system = rs.getInt( 11 );
			_credit_control = rs.getInt( 12 );
			_min_qtr_credits = rs.getDouble( 13 );
			_max_qtr_credits = rs.getDouble( 14 );
			_max_credits = rs.getDouble( 15 );
			_approved_dt = rs.getTimestamp( 16 );
			_approved_dt_has = !rs.wasNull();
			_changed_dt = rs.getTimestamp( 17 );
			_changed_dt_has = !rs.wasNull();
			_dropped_dt = rs.getTimestamp( 18 );
			_dropped_dt_has = !rs.wasNull();
			_last_update_dt = rs.getTimestamp( 19 );
			_last_update_dt_has = !rs.wasNull();
			_sr_crs_dl_appr_dt = rs.getTimestamp( 20 );
			_sr_crs_dl_appr_dt_has = !rs.wasNull();
			_deductible = rs.getBoolean( 21 );
			_honors = rs.getBoolean( 22 );
			_dup_enroll = rs.getBoolean( 23 );
			_course_ts_omit = rs.getBoolean( 24 );
			_course_cat_omit = rs.getBoolean( 25 );
			_writing_crs = rs.getBoolean( 26 );
			_english_comp = rs.getBoolean( 27 );
			_qsr = rs.getBoolean( 28 );
			_vis_lit_perf_arts = rs.getBoolean( 29 );
			_indiv_society = rs.getBoolean( 30 );
			_natural_world = rs.getBoolean( 31 );
			_diversity_crs = rs.getBoolean( 32 );
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

	private int _grading_system = 0;

	/** grading_system **/
	public int getGrading_system()
	{
		return _grading_system;
	}	

	private int _credit_control = 0;

	/** credit_control **/
	public int getCredit_control()
	{
		return _credit_control;
	}	

	private double _min_qtr_credits = 0d;

	/** min_qtr_credits **/
	public double getMin_qtr_credits()
	{
		return _min_qtr_credits;
	}	

	private double _max_qtr_credits = 0d;

	/** max_qtr_credits **/
	public double getMax_qtr_credits()
	{
		return _max_qtr_credits;
	}	

	private double _max_credits = 0d;

	/** max_credits **/
	public double getMax_credits()
	{
		return _max_credits;
	}	

	private java.sql.Timestamp _approved_dt = null;

	/** approved_dt **/
	public java.sql.Timestamp getApproved_dt()
	{
		return _approved_dt;
	}	

	private boolean _approved_dt_has = false;
	
	/** returns true if approved_dt is non-null **/
	public boolean hasApproved_dt()
	{
		return _approved_dt_has;
	}	
	
	private java.sql.Timestamp _changed_dt = null;

	/** changed_dt **/
	public java.sql.Timestamp getChanged_dt()
	{
		return _changed_dt;
	}	

	private boolean _changed_dt_has = false;
	
	/** returns true if changed_dt is non-null **/
	public boolean hasChanged_dt()
	{
		return _changed_dt_has;
	}	
	
	private java.sql.Timestamp _dropped_dt = null;

	/** dropped_dt **/
	public java.sql.Timestamp getDropped_dt()
	{
		return _dropped_dt;
	}	

	private boolean _dropped_dt_has = false;
	
	/** returns true if dropped_dt is non-null **/
	public boolean hasDropped_dt()
	{
		return _dropped_dt_has;
	}	
	
	private java.sql.Timestamp _last_update_dt = null;

	/** last_update_dt **/
	public java.sql.Timestamp getLast_update_dt()
	{
		return _last_update_dt;
	}	

	private boolean _last_update_dt_has = false;
	
	/** returns true if last_update_dt is non-null **/
	public boolean hasLast_update_dt()
	{
		return _last_update_dt_has;
	}	
	
	private java.sql.Timestamp _sr_crs_dl_appr_dt = null;

	/** sr_crs_dl_appr_dt **/
	public java.sql.Timestamp getSr_crs_dl_appr_dt()
	{
		return _sr_crs_dl_appr_dt;
	}	

	private boolean _sr_crs_dl_appr_dt_has = false;
	
	/** returns true if sr_crs_dl_appr_dt is non-null **/
	public boolean hasSr_crs_dl_appr_dt()
	{
		return _sr_crs_dl_appr_dt_has;
	}	
	
	private boolean _deductible = false;

	/** deductible **/
	public boolean getDeductible()
	{
		return _deductible;
	}	

	private boolean _honors = false;

	/** honors **/
	public boolean getHonors()
	{
		return _honors;
	}	

	private boolean _dup_enroll = false;

	/** dup_enroll **/
	public boolean getDup_enroll()
	{
		return _dup_enroll;
	}	

	private boolean _course_ts_omit = false;

	/** course_ts_omit **/
	public boolean getCourse_ts_omit()
	{
		return _course_ts_omit;
	}	

	private boolean _course_cat_omit = false;

	/** course_cat_omit **/
	public boolean getCourse_cat_omit()
	{
		return _course_cat_omit;
	}	

	private boolean _writing_crs = false;

	/** writing_crs **/
	public boolean getWriting_crs()
	{
		return _writing_crs;
	}	

	private boolean _english_comp = false;

	/** english_comp **/
	public boolean getEnglish_comp()
	{
		return _english_comp;
	}	

	private boolean _qsr = false;

	/** qsr **/
	public boolean getQsr()
	{
		return _qsr;
	}	

	private boolean _vis_lit_perf_arts = false;

	/** vis_lit_perf_arts **/
	public boolean getVis_lit_perf_arts()
	{
		return _vis_lit_perf_arts;
	}	

	private boolean _indiv_society = false;

	/** indiv_society **/
	public boolean getIndiv_society()
	{
		return _indiv_society;
	}	

	private boolean _natural_world = false;

	/** natural_world **/
	public boolean getNatural_world()
	{
		return _natural_world;
	}	

	private boolean _diversity_crs = false;

	/** diversity_crs **/
	public boolean getDiversity_crs()
	{
		return _diversity_crs;
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
		sb.append( "Grading_system: " );
		sb.append( getGrading_system() );
		sb.append( "\n" );
		sb.append( "Credit_control: " );
		sb.append( getCredit_control() );
		sb.append( "\n" );
		sb.append( "Min_qtr_credits: " );
		sb.append( getMin_qtr_credits() );
		sb.append( "\n" );
		sb.append( "Max_qtr_credits: " );
		sb.append( getMax_qtr_credits() );
		sb.append( "\n" );
		sb.append( "Max_credits: " );
		sb.append( getMax_credits() );
		sb.append( "\n" );
		sb.append( "Approved_dt: " );
		sb.append( getApproved_dt() );
		sb.append( "\n" );
		sb.append( "Changed_dt: " );
		sb.append( getChanged_dt() );
		sb.append( "\n" );
		sb.append( "Dropped_dt: " );
		sb.append( getDropped_dt() );
		sb.append( "\n" );
		sb.append( "Last_update_dt: " );
		sb.append( getLast_update_dt() );
		sb.append( "\n" );
		sb.append( "Sr_crs_dl_appr_dt: " );
		sb.append( getSr_crs_dl_appr_dt() );
		sb.append( "\n" );
		sb.append( "Deductible: " );
		sb.append( getDeductible() );
		sb.append( "\n" );
		sb.append( "Honors: " );
		sb.append( getHonors() );
		sb.append( "\n" );
		sb.append( "Dup_enroll: " );
		sb.append( getDup_enroll() );
		sb.append( "\n" );
		sb.append( "Course_ts_omit: " );
		sb.append( getCourse_ts_omit() );
		sb.append( "\n" );
		sb.append( "Course_cat_omit: " );
		sb.append( getCourse_cat_omit() );
		sb.append( "\n" );
		sb.append( "Writing_crs: " );
		sb.append( getWriting_crs() );
		sb.append( "\n" );
		sb.append( "English_comp: " );
		sb.append( getEnglish_comp() );
		sb.append( "\n" );
		sb.append( "Qsr: " );
		sb.append( getQsr() );
		sb.append( "\n" );
		sb.append( "Vis_lit_perf_arts: " );
		sb.append( getVis_lit_perf_arts() );
		sb.append( "\n" );
		sb.append( "Indiv_society: " );
		sb.append( getIndiv_society() );
		sb.append( "\n" );
		sb.append( "Natural_world: " );
		sb.append( getNatural_world() );
		sb.append( "\n" );
		sb.append( "Diversity_crs: " );
		sb.append( getDiversity_crs() );
		sb.append( "\n" );
		return sb.toString();
	}
}

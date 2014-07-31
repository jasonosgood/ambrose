
/**

UpdateCourse.java   Wed Jul 30 06:47:32 PDT 2014
  
Generated using Fado's Update.vm template. Original SQL:
    
UPDATE Course 
SET
	department_abbrev = 'TOP',
	course_number = 200,
	long_course_title = 'Course catalog title goes here',
	course_title = 'Transcript title goes here',
	course_college = 'J',
	description = 'description goes here',
	course_branch = 0,
	lastATP = 99994,
	firstATP = 19701,
	grading_system = 0,
	credit_control = 0,
	min_qtr_credits = 1,
	max_qtr_credits = 10,
	max_credits = 10,
	approved_dt = '2013-12-02 00:00:00.0',
	changed_dt = '2013-12-02 00:00:00.0',
	dropped_dt = '2013-12-02 00:00:00.0',
	last_update_dt = '2013-12-02 00:00:00.0',
	sr_crs_dl_appr_dt = '2013-12-02 00:00:00.0',
	deductible = false,
	honors = false,
	dup_enroll = false,
	course_ts_omit = false,
	course_cat_omit = false,
	writing_crs = false,
	english_comp = false,
	qsr = false,
	vis_lit_perf_arts = false,
	indiv_society = false,
	natural_world = false,
	diversity_crs = false,
	hyphen_type = 0,
	prior_dept_abbr = 'ABC',
	prior_course_num = '123',
	resp_curric_abbr = 'ABC',
	resp_course_no = '123' 
WHERE 
	ID = 1

@see ./UpdateCourse.sql
  
**/

package cm;

import java.sql.*;
import javax.sql.DataSource;
import java.math.BigDecimal;

public class 
	UpdateCourse
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
		
		
		ps.setString( 1, getDepartment_abbrev() );
		ps.setInt( 2, getCourse_number() );
		ps.setString( 3, getLong_course_title() );
		ps.setString( 4, getCourse_title() );
		ps.setString( 5, getCourse_college() );
		ps.setString( 6, getDescription() );
		ps.setInt( 7, getCourse_branch() );
		ps.setInt( 8, getLastATP() );
		ps.setInt( 9, getFirstATP() );
		ps.setInt( 10, getGrading_system() );
		ps.setInt( 11, getCredit_control() );
		ps.setDouble( 12, getMin_qtr_credits() );
		ps.setDouble( 13, getMax_qtr_credits() );
		ps.setDouble( 14, getMax_credits() );
		ps.setTimestamp( 15, getApproved_dt() );
		ps.setTimestamp( 16, getChanged_dt() );
		ps.setTimestamp( 17, getDropped_dt() );
		ps.setTimestamp( 18, getLast_update_dt() );
		ps.setTimestamp( 19, getSr_crs_dl_appr_dt() );
		ps.setBoolean( 20, getDeductible() );
		ps.setBoolean( 21, getHonors() );
		ps.setBoolean( 22, getDup_enroll() );
		ps.setBoolean( 23, getCourse_ts_omit() );
		ps.setBoolean( 24, getCourse_cat_omit() );
		ps.setBoolean( 25, getWriting_crs() );
		ps.setBoolean( 26, getEnglish_comp() );
		ps.setBoolean( 27, getQsr() );
		ps.setBoolean( 28, getVis_lit_perf_arts() );
		ps.setBoolean( 29, getIndiv_society() );
		ps.setBoolean( 30, getNatural_world() );
		ps.setBoolean( 31, getDiversity_crs() );
		ps.setInt( 32, getHyphen_type() );
		ps.setString( 33, getPrior_dept_abbr() );
		ps.setInt( 34, getPrior_course_num() );
		ps.setString( 35, getResp_curric_abbr() );
		ps.setInt( 36, getResp_course_no() );
		ps.setLong( 37, getIDParam() );
		int rows = ps.executeUpdate();
		return rows;
	}
	
	
	
	private java.lang.String _department_abbrev = "TOP";
	private int _course_number = 200;
	private java.lang.String _long_course_title = "Course catalog title goes here";
	private java.lang.String _course_title = "Transcript title goes here";
	private java.lang.String _course_college = "J";
	private String _description = "description goes here";
	private int _course_branch = 0;
	private int _lastATP = 99994;
	private int _firstATP = 19701;
	private int _grading_system = 0;
	private int _credit_control = 0;
	private double _min_qtr_credits = 1d;
	private double _max_qtr_credits = 10d;
	private double _max_credits = 10d;
	private java.sql.Timestamp _approved_dt = java.sql.Timestamp.valueOf( "2013-12-02 00:00:00.0" );
	private java.sql.Timestamp _changed_dt = java.sql.Timestamp.valueOf( "2013-12-02 00:00:00.0" );
	private java.sql.Timestamp _dropped_dt = java.sql.Timestamp.valueOf( "2013-12-02 00:00:00.0" );
	private java.sql.Timestamp _last_update_dt = java.sql.Timestamp.valueOf( "2013-12-02 00:00:00.0" );
	private java.sql.Timestamp _sr_crs_dl_appr_dt = java.sql.Timestamp.valueOf( "2013-12-02 00:00:00.0" );
	private boolean _deductible = false;
	private boolean _honors = false;
	private boolean _dup_enroll = false;
	private boolean _course_ts_omit = false;
	private boolean _course_cat_omit = false;
	private boolean _writing_crs = false;
	private boolean _english_comp = false;
	private boolean _qsr = false;
	private boolean _vis_lit_perf_arts = false;
	private boolean _indiv_society = false;
	private boolean _natural_world = false;
	private boolean _diversity_crs = false;
	private int _hyphen_type = 0;
	private java.lang.String _prior_dept_abbr = "ABC";
	private int _prior_course_num = 123;
	private java.lang.String _resp_curric_abbr = "ABC";
	private int _resp_course_no = 123;

	public void setDepartment_abbrev( java.lang.String department_abbrev )
	{
		_department_abbrev = department_abbrev;
	}
	
	public java.lang.String getDepartment_abbrev()
	{
		return _department_abbrev;
	}	

	public void setCourse_number( int course_number )
	{
		_course_number = course_number;
	}
	
	public int getCourse_number()
	{
		return _course_number;
	}	

	public void setLong_course_title( java.lang.String long_course_title )
	{
		_long_course_title = long_course_title;
	}
	
	public java.lang.String getLong_course_title()
	{
		return _long_course_title;
	}	

	public void setCourse_title( java.lang.String course_title )
	{
		_course_title = course_title;
	}
	
	public java.lang.String getCourse_title()
	{
		return _course_title;
	}	

	public void setCourse_college( java.lang.String course_college )
	{
		_course_college = course_college;
	}
	
	public java.lang.String getCourse_college()
	{
		return _course_college;
	}	

	public void setDescription( String description )
	{
		_description = description;
	}
	
	public String getDescription()
	{
		return _description;
	}	

	public void setCourse_branch( int course_branch )
	{
		_course_branch = course_branch;
	}
	
	public int getCourse_branch()
	{
		return _course_branch;
	}	

	public void setLastATP( int lastATP )
	{
		_lastATP = lastATP;
	}
	
	public int getLastATP()
	{
		return _lastATP;
	}	

	public void setFirstATP( int firstATP )
	{
		_firstATP = firstATP;
	}
	
	public int getFirstATP()
	{
		return _firstATP;
	}	

	public void setGrading_system( int grading_system )
	{
		_grading_system = grading_system;
	}
	
	public int getGrading_system()
	{
		return _grading_system;
	}	

	public void setCredit_control( int credit_control )
	{
		_credit_control = credit_control;
	}
	
	public int getCredit_control()
	{
		return _credit_control;
	}	

	public void setMin_qtr_credits( double min_qtr_credits )
	{
		_min_qtr_credits = min_qtr_credits;
	}
	
	public double getMin_qtr_credits()
	{
		return _min_qtr_credits;
	}	

	public void setMax_qtr_credits( double max_qtr_credits )
	{
		_max_qtr_credits = max_qtr_credits;
	}
	
	public double getMax_qtr_credits()
	{
		return _max_qtr_credits;
	}	

	public void setMax_credits( double max_credits )
	{
		_max_credits = max_credits;
	}
	
	public double getMax_credits()
	{
		return _max_credits;
	}	

	public void setApproved_dt( java.sql.Timestamp approved_dt )
	{
		_approved_dt = approved_dt;
	}
	
	public java.sql.Timestamp getApproved_dt()
	{
		return _approved_dt;
	}	

	public void setChanged_dt( java.sql.Timestamp changed_dt )
	{
		_changed_dt = changed_dt;
	}
	
	public java.sql.Timestamp getChanged_dt()
	{
		return _changed_dt;
	}	

	public void setDropped_dt( java.sql.Timestamp dropped_dt )
	{
		_dropped_dt = dropped_dt;
	}
	
	public java.sql.Timestamp getDropped_dt()
	{
		return _dropped_dt;
	}	

	public void setLast_update_dt( java.sql.Timestamp last_update_dt )
	{
		_last_update_dt = last_update_dt;
	}
	
	public java.sql.Timestamp getLast_update_dt()
	{
		return _last_update_dt;
	}	

	public void setSr_crs_dl_appr_dt( java.sql.Timestamp sr_crs_dl_appr_dt )
	{
		_sr_crs_dl_appr_dt = sr_crs_dl_appr_dt;
	}
	
	public java.sql.Timestamp getSr_crs_dl_appr_dt()
	{
		return _sr_crs_dl_appr_dt;
	}	

	public void setDeductible( boolean deductible )
	{
		_deductible = deductible;
	}
	
	public boolean getDeductible()
	{
		return _deductible;
	}	

	public void setHonors( boolean honors )
	{
		_honors = honors;
	}
	
	public boolean getHonors()
	{
		return _honors;
	}	

	public void setDup_enroll( boolean dup_enroll )
	{
		_dup_enroll = dup_enroll;
	}
	
	public boolean getDup_enroll()
	{
		return _dup_enroll;
	}	

	public void setCourse_ts_omit( boolean course_ts_omit )
	{
		_course_ts_omit = course_ts_omit;
	}
	
	public boolean getCourse_ts_omit()
	{
		return _course_ts_omit;
	}	

	public void setCourse_cat_omit( boolean course_cat_omit )
	{
		_course_cat_omit = course_cat_omit;
	}
	
	public boolean getCourse_cat_omit()
	{
		return _course_cat_omit;
	}	

	public void setWriting_crs( boolean writing_crs )
	{
		_writing_crs = writing_crs;
	}
	
	public boolean getWriting_crs()
	{
		return _writing_crs;
	}	

	public void setEnglish_comp( boolean english_comp )
	{
		_english_comp = english_comp;
	}
	
	public boolean getEnglish_comp()
	{
		return _english_comp;
	}	

	public void setQsr( boolean qsr )
	{
		_qsr = qsr;
	}
	
	public boolean getQsr()
	{
		return _qsr;
	}	

	public void setVis_lit_perf_arts( boolean vis_lit_perf_arts )
	{
		_vis_lit_perf_arts = vis_lit_perf_arts;
	}
	
	public boolean getVis_lit_perf_arts()
	{
		return _vis_lit_perf_arts;
	}	

	public void setIndiv_society( boolean indiv_society )
	{
		_indiv_society = indiv_society;
	}
	
	public boolean getIndiv_society()
	{
		return _indiv_society;
	}	

	public void setNatural_world( boolean natural_world )
	{
		_natural_world = natural_world;
	}
	
	public boolean getNatural_world()
	{
		return _natural_world;
	}	

	public void setDiversity_crs( boolean diversity_crs )
	{
		_diversity_crs = diversity_crs;
	}
	
	public boolean getDiversity_crs()
	{
		return _diversity_crs;
	}	

	public void setHyphen_type( int hyphen_type )
	{
		_hyphen_type = hyphen_type;
	}
	
	public int getHyphen_type()
	{
		return _hyphen_type;
	}	

	public void setPrior_dept_abbr( java.lang.String prior_dept_abbr )
	{
		_prior_dept_abbr = prior_dept_abbr;
	}
	
	public java.lang.String getPrior_dept_abbr()
	{
		return _prior_dept_abbr;
	}	

	public void setPrior_course_num( int prior_course_num )
	{
		_prior_course_num = prior_course_num;
	}
	
	public int getPrior_course_num()
	{
		return _prior_course_num;
	}	

	public void setResp_curric_abbr( java.lang.String resp_curric_abbr )
	{
		_resp_curric_abbr = resp_curric_abbr;
	}
	
	public java.lang.String getResp_curric_abbr()
	{
		return _resp_curric_abbr;
	}	

	public void setResp_course_no( int resp_course_no )
	{
		_resp_course_no = resp_course_no;
	}
	
	public int getResp_course_no()
	{
		return _resp_course_no;
	}	



	public long _idParam = 1L;
	
	public void setIDParam( long id )
	{
		_idParam = id;
	}
	
	public long getIDParam()
	{
		return _idParam;
	}

	
	private static String __sql = null;

	public String getSQL()
	{
		if( __sql == null )
		{
			StringBuilder sb = new StringBuilder();
			sb.append( "UPDATE Course " );
			sb.append( '\n' );
			sb.append( "SET" );
			sb.append( '\n' );
			sb.append( "	department_abbrev = ?," );
			sb.append( '\n' );
			sb.append( "	course_number = ?," );
			sb.append( '\n' );
			sb.append( "	long_course_title = ?," );
			sb.append( '\n' );
			sb.append( "	course_title = ?," );
			sb.append( '\n' );
			sb.append( "	course_college = ?," );
			sb.append( '\n' );
			sb.append( "	description = ?," );
			sb.append( '\n' );
			sb.append( "	course_branch = ?," );
			sb.append( '\n' );
			sb.append( "	lastATP = ?," );
			sb.append( '\n' );
			sb.append( "	firstATP = ?," );
			sb.append( '\n' );
			sb.append( "	grading_system = ?," );
			sb.append( '\n' );
			sb.append( "	credit_control = ?," );
			sb.append( '\n' );
			sb.append( "	min_qtr_credits = ?," );
			sb.append( '\n' );
			sb.append( "	max_qtr_credits = ?," );
			sb.append( '\n' );
			sb.append( "	max_credits = ?," );
			sb.append( '\n' );
			sb.append( "	approved_dt = ?," );
			sb.append( '\n' );
			sb.append( "	changed_dt = ?," );
			sb.append( '\n' );
			sb.append( "	dropped_dt = ?," );
			sb.append( '\n' );
			sb.append( "	last_update_dt = ?," );
			sb.append( '\n' );
			sb.append( "	sr_crs_dl_appr_dt = ?," );
			sb.append( '\n' );
			sb.append( "	deductible = ?," );
			sb.append( '\n' );
			sb.append( "	honors = ?," );
			sb.append( '\n' );
			sb.append( "	dup_enroll = ?," );
			sb.append( '\n' );
			sb.append( "	course_ts_omit = ?," );
			sb.append( '\n' );
			sb.append( "	course_cat_omit = ?," );
			sb.append( '\n' );
			sb.append( "	writing_crs = ?," );
			sb.append( '\n' );
			sb.append( "	english_comp = ?," );
			sb.append( '\n' );
			sb.append( "	qsr = ?," );
			sb.append( '\n' );
			sb.append( "	vis_lit_perf_arts = ?," );
			sb.append( '\n' );
			sb.append( "	indiv_society = ?," );
			sb.append( '\n' );
			sb.append( "	natural_world = ?," );
			sb.append( '\n' );
			sb.append( "	diversity_crs = ?," );
			sb.append( '\n' );
			sb.append( "	hyphen_type = ?," );
			sb.append( '\n' );
			sb.append( "	prior_dept_abbr = ?," );
			sb.append( '\n' );
			sb.append( "	prior_course_num = ?," );
			sb.append( '\n' );
			sb.append( "	resp_curric_abbr = ?," );
			sb.append( '\n' );
			sb.append( "	resp_course_no = ? " );
			sb.append( '\n' );
			sb.append( "WHERE " );
			sb.append( '\n' );
			sb.append( "	ID = ?" );
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
		result = result.replaceFirst( "\\?", quotifyString( getLong_course_title() ));
		result = result.replaceFirst( "\\?", quotifyString( getCourse_title() ));
		result = result.replaceFirst( "\\?", quotifyString( getCourse_college() ));
		result = result.replaceFirst( "\\?", quotifyString( getDescription() ));
		result = result.replaceFirst( "\\?", quotifyString( getCourse_branch() ));
		result = result.replaceFirst( "\\?", quotifyString( getLastATP() ));
		result = result.replaceFirst( "\\?", quotifyString( getFirstATP() ));
		result = result.replaceFirst( "\\?", quotifyString( getGrading_system() ));
		result = result.replaceFirst( "\\?", quotifyString( getCredit_control() ));
		result = result.replaceFirst( "\\?", quotifyString( getMin_qtr_credits() ));
		result = result.replaceFirst( "\\?", quotifyString( getMax_qtr_credits() ));
		result = result.replaceFirst( "\\?", quotifyString( getMax_credits() ));
		result = result.replaceFirst( "\\?", quotifyString( getApproved_dt() ));
		result = result.replaceFirst( "\\?", quotifyString( getChanged_dt() ));
		result = result.replaceFirst( "\\?", quotifyString( getDropped_dt() ));
		result = result.replaceFirst( "\\?", quotifyString( getLast_update_dt() ));
		result = result.replaceFirst( "\\?", quotifyString( getSr_crs_dl_appr_dt() ));
		result = result.replaceFirst( "\\?", quotifyString( getDeductible() ));
		result = result.replaceFirst( "\\?", quotifyString( getHonors() ));
		result = result.replaceFirst( "\\?", quotifyString( getDup_enroll() ));
		result = result.replaceFirst( "\\?", quotifyString( getCourse_ts_omit() ));
		result = result.replaceFirst( "\\?", quotifyString( getCourse_cat_omit() ));
		result = result.replaceFirst( "\\?", quotifyString( getWriting_crs() ));
		result = result.replaceFirst( "\\?", quotifyString( getEnglish_comp() ));
		result = result.replaceFirst( "\\?", quotifyString( getQsr() ));
		result = result.replaceFirst( "\\?", quotifyString( getVis_lit_perf_arts() ));
		result = result.replaceFirst( "\\?", quotifyString( getIndiv_society() ));
		result = result.replaceFirst( "\\?", quotifyString( getNatural_world() ));
		result = result.replaceFirst( "\\?", quotifyString( getDiversity_crs() ));
		result = result.replaceFirst( "\\?", quotifyString( getHyphen_type() ));
		result = result.replaceFirst( "\\?", quotifyString( getPrior_dept_abbr() ));
		result = result.replaceFirst( "\\?", quotifyString( getPrior_course_num() ));
		result = result.replaceFirst( "\\?", quotifyString( getResp_curric_abbr() ));
		result = result.replaceFirst( "\\?", quotifyString( getResp_course_no() ));
		result = result.replaceFirst( "\\?", quotifyString( getIDParam() ));
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

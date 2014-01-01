/**

SelectCourseDetailsResultSet.java   Fri Dec 06 11:33:38 PST 2013
  
Generated using Fado's ResultSet.vm template. Original SQL:
    
SELECT
	department_abbrev,
	course_number,
	long_course_title,
	course_title,
	course_college,
	course_branch,
	
	-- atp
	( last_eff_yr * 10 ) + last_eff_qtr as lastATP,
	( first_eff_yr * 10 ) + first_eff_qtr as firstATP,
	
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
	diversity_crs,
	
	-- course sequence
	hyphen_type,
	prior_dept_abbr,
	prior_course_num,

	resp_curric_abbr,
	resp_course_no
	
FROM 
	sr_course_titles
WHERE 
(
	( last_eff_yr * 10 ) + last_eff_qtr < 20134
	OR ( department_abbrev = resp_curric_abbr AND course_number = resp_course_no )
	OR resp_course_no = 0
)
ORDER BY 
	department_abbrev, 
	course_number, 
	first_eff_yr, 
	first_eff_qtr

@see ./SelectCourseDetails.sql
  

**/

package uwsdb;

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
			_department_abbrev = rs.getString( 1 );
			_department_abbrev_has = !rs.wasNull();
			_course_number = rs.getShort( 2 );
			_course_number_has = !rs.wasNull();
			_long_course_title = rs.getString( 3 );
			_long_course_title_has = !rs.wasNull();
			_course_title = rs.getString( 4 );
			_course_title_has = !rs.wasNull();
			_course_college = rs.getString( 5 );
			_course_college_has = !rs.wasNull();
			_course_branch = rs.getShort( 6 );
			_course_branch_has = !rs.wasNull();
			_lastATP = rs.getInt( 7 );
			_lastATP_has = !rs.wasNull();
			_firstATP = rs.getInt( 8 );
			_firstATP_has = !rs.wasNull();
			_grading_system = rs.getShort( 9 );
			_grading_system_has = !rs.wasNull();
			_credit_control = rs.getShort( 10 );
			_credit_control_has = !rs.wasNull();
			_min_qtr_credits = rs.getBigDecimal( 11 );
			_min_qtr_credits_has = !rs.wasNull();
			_max_qtr_credits = rs.getBigDecimal( 12 );
			_max_qtr_credits_has = !rs.wasNull();
			_max_credits = rs.getBigDecimal( 13 );
			_max_credits_has = !rs.wasNull();
			_approved_dt = rs.getTimestamp( 14 );
			_approved_dt_has = !rs.wasNull();
			_changed_dt = rs.getTimestamp( 15 );
			_changed_dt_has = !rs.wasNull();
			_dropped_dt = rs.getTimestamp( 16 );
			_dropped_dt_has = !rs.wasNull();
			_last_update_dt = rs.getTimestamp( 17 );
			_last_update_dt_has = !rs.wasNull();
			_sr_crs_dl_appr_dt = rs.getTimestamp( 18 );
			_sr_crs_dl_appr_dt_has = !rs.wasNull();
			_deductible = rs.getBoolean( 19 );
			_deductible_has = !rs.wasNull();
			_honors = rs.getBoolean( 20 );
			_honors_has = !rs.wasNull();
			_dup_enroll = rs.getBoolean( 21 );
			_dup_enroll_has = !rs.wasNull();
			_course_ts_omit = rs.getBoolean( 22 );
			_course_ts_omit_has = !rs.wasNull();
			_course_cat_omit = rs.getBoolean( 23 );
			_course_cat_omit_has = !rs.wasNull();
			_writing_crs = rs.getBoolean( 24 );
			_writing_crs_has = !rs.wasNull();
			_english_comp = rs.getBoolean( 25 );
			_english_comp_has = !rs.wasNull();
			_qsr = rs.getBoolean( 26 );
			_qsr_has = !rs.wasNull();
			_vis_lit_perf_arts = rs.getBoolean( 27 );
			_vis_lit_perf_arts_has = !rs.wasNull();
			_indiv_society = rs.getBoolean( 28 );
			_indiv_society_has = !rs.wasNull();
			_natural_world = rs.getBoolean( 29 );
			_natural_world_has = !rs.wasNull();
			_diversity_crs = rs.getBoolean( 30 );
			_diversity_crs_has = !rs.wasNull();
			_hyphen_type = rs.getShort( 31 );
			_hyphen_type_has = !rs.wasNull();
			_prior_dept_abbr = rs.getString( 32 );
			_prior_dept_abbr_has = !rs.wasNull();
			_prior_course_num = rs.getShort( 33 );
			_prior_course_num_has = !rs.wasNull();
			_resp_curric_abbr = rs.getString( 34 );
			_resp_curric_abbr_has = !rs.wasNull();
			_resp_course_no = rs.getShort( 35 );
			_resp_course_no_has = !rs.wasNull();
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
	
	private java.lang.String _department_abbrev = null;

	/** department_abbrev **/
	public java.lang.String getDepartment_abbrev()
	{
		return _department_abbrev;
	}	

	private boolean _department_abbrev_has = false;
	
	/** returns true if department_abbrev is non-null **/
	public boolean hasDepartment_abbrev()
	{
		return _department_abbrev_has;
	}	
	
	private short _course_number = 0;

	/** course_number **/
	public short getCourse_number()
	{
		return _course_number;
	}	

	private boolean _course_number_has = false;
	
	/** returns true if course_number is non-null **/
	public boolean hasCourse_number()
	{
		return _course_number_has;
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
	
	private java.lang.String _course_college = null;

	/** course_college **/
	public java.lang.String getCourse_college()
	{
		return _course_college;
	}	

	private boolean _course_college_has = false;
	
	/** returns true if course_college is non-null **/
	public boolean hasCourse_college()
	{
		return _course_college_has;
	}	
	
	private short _course_branch = 0;

	/** course_branch **/
	public short getCourse_branch()
	{
		return _course_branch;
	}	

	private boolean _course_branch_has = false;
	
	/** returns true if course_branch is non-null **/
	public boolean hasCourse_branch()
	{
		return _course_branch_has;
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
	
	private int _firstATP = 0;

	/** firstATP **/
	public int getFirstATP()
	{
		return _firstATP;
	}	

	private boolean _firstATP_has = false;
	
	/** returns true if firstATP is non-null **/
	public boolean hasFirstATP()
	{
		return _firstATP_has;
	}	
	
	private short _grading_system = 0;

	/** grading_system **/
	public short getGrading_system()
	{
		return _grading_system;
	}	

	private boolean _grading_system_has = false;
	
	/** returns true if grading_system is non-null **/
	public boolean hasGrading_system()
	{
		return _grading_system_has;
	}	
	
	private short _credit_control = 0;

	/** credit_control **/
	public short getCredit_control()
	{
		return _credit_control;
	}	

	private boolean _credit_control_has = false;
	
	/** returns true if credit_control is non-null **/
	public boolean hasCredit_control()
	{
		return _credit_control_has;
	}	
	
	private java.math.BigDecimal _min_qtr_credits = null;

	/** min_qtr_credits **/
	public java.math.BigDecimal getMin_qtr_credits()
	{
		return _min_qtr_credits;
	}	

	private boolean _min_qtr_credits_has = false;
	
	/** returns true if min_qtr_credits is non-null **/
	public boolean hasMin_qtr_credits()
	{
		return _min_qtr_credits_has;
	}	
	
	private java.math.BigDecimal _max_qtr_credits = null;

	/** max_qtr_credits **/
	public java.math.BigDecimal getMax_qtr_credits()
	{
		return _max_qtr_credits;
	}	

	private boolean _max_qtr_credits_has = false;
	
	/** returns true if max_qtr_credits is non-null **/
	public boolean hasMax_qtr_credits()
	{
		return _max_qtr_credits_has;
	}	
	
	private java.math.BigDecimal _max_credits = null;

	/** max_credits **/
	public java.math.BigDecimal getMax_credits()
	{
		return _max_credits;
	}	

	private boolean _max_credits_has = false;
	
	/** returns true if max_credits is non-null **/
	public boolean hasMax_credits()
	{
		return _max_credits_has;
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

	private boolean _deductible_has = false;
	
	/** returns true if deductible is non-null **/
	public boolean hasDeductible()
	{
		return _deductible_has;
	}	
	
	private boolean _honors = false;

	/** honors **/
	public boolean getHonors()
	{
		return _honors;
	}	

	private boolean _honors_has = false;
	
	/** returns true if honors is non-null **/
	public boolean hasHonors()
	{
		return _honors_has;
	}	
	
	private boolean _dup_enroll = false;

	/** dup_enroll **/
	public boolean getDup_enroll()
	{
		return _dup_enroll;
	}	

	private boolean _dup_enroll_has = false;
	
	/** returns true if dup_enroll is non-null **/
	public boolean hasDup_enroll()
	{
		return _dup_enroll_has;
	}	
	
	private boolean _course_ts_omit = false;

	/** course_ts_omit **/
	public boolean getCourse_ts_omit()
	{
		return _course_ts_omit;
	}	

	private boolean _course_ts_omit_has = false;
	
	/** returns true if course_ts_omit is non-null **/
	public boolean hasCourse_ts_omit()
	{
		return _course_ts_omit_has;
	}	
	
	private boolean _course_cat_omit = false;

	/** course_cat_omit **/
	public boolean getCourse_cat_omit()
	{
		return _course_cat_omit;
	}	

	private boolean _course_cat_omit_has = false;
	
	/** returns true if course_cat_omit is non-null **/
	public boolean hasCourse_cat_omit()
	{
		return _course_cat_omit_has;
	}	
	
	private boolean _writing_crs = false;

	/** writing_crs **/
	public boolean getWriting_crs()
	{
		return _writing_crs;
	}	

	private boolean _writing_crs_has = false;
	
	/** returns true if writing_crs is non-null **/
	public boolean hasWriting_crs()
	{
		return _writing_crs_has;
	}	
	
	private boolean _english_comp = false;

	/** english_comp **/
	public boolean getEnglish_comp()
	{
		return _english_comp;
	}	

	private boolean _english_comp_has = false;
	
	/** returns true if english_comp is non-null **/
	public boolean hasEnglish_comp()
	{
		return _english_comp_has;
	}	
	
	private boolean _qsr = false;

	/** qsr **/
	public boolean getQsr()
	{
		return _qsr;
	}	

	private boolean _qsr_has = false;
	
	/** returns true if qsr is non-null **/
	public boolean hasQsr()
	{
		return _qsr_has;
	}	
	
	private boolean _vis_lit_perf_arts = false;

	/** vis_lit_perf_arts **/
	public boolean getVis_lit_perf_arts()
	{
		return _vis_lit_perf_arts;
	}	

	private boolean _vis_lit_perf_arts_has = false;
	
	/** returns true if vis_lit_perf_arts is non-null **/
	public boolean hasVis_lit_perf_arts()
	{
		return _vis_lit_perf_arts_has;
	}	
	
	private boolean _indiv_society = false;

	/** indiv_society **/
	public boolean getIndiv_society()
	{
		return _indiv_society;
	}	

	private boolean _indiv_society_has = false;
	
	/** returns true if indiv_society is non-null **/
	public boolean hasIndiv_society()
	{
		return _indiv_society_has;
	}	
	
	private boolean _natural_world = false;

	/** natural_world **/
	public boolean getNatural_world()
	{
		return _natural_world;
	}	

	private boolean _natural_world_has = false;
	
	/** returns true if natural_world is non-null **/
	public boolean hasNatural_world()
	{
		return _natural_world_has;
	}	
	
	private boolean _diversity_crs = false;

	/** diversity_crs **/
	public boolean getDiversity_crs()
	{
		return _diversity_crs;
	}	

	private boolean _diversity_crs_has = false;
	
	/** returns true if diversity_crs is non-null **/
	public boolean hasDiversity_crs()
	{
		return _diversity_crs_has;
	}	
	
	private short _hyphen_type = 0;

	/** hyphen_type **/
	public short getHyphen_type()
	{
		return _hyphen_type;
	}	

	private boolean _hyphen_type_has = false;
	
	/** returns true if hyphen_type is non-null **/
	public boolean hasHyphen_type()
	{
		return _hyphen_type_has;
	}	
	
	private java.lang.String _prior_dept_abbr = null;

	/** prior_dept_abbr **/
	public java.lang.String getPrior_dept_abbr()
	{
		return _prior_dept_abbr;
	}	

	private boolean _prior_dept_abbr_has = false;
	
	/** returns true if prior_dept_abbr is non-null **/
	public boolean hasPrior_dept_abbr()
	{
		return _prior_dept_abbr_has;
	}	
	
	private short _prior_course_num = 0;

	/** prior_course_num **/
	public short getPrior_course_num()
	{
		return _prior_course_num;
	}	

	private boolean _prior_course_num_has = false;
	
	/** returns true if prior_course_num is non-null **/
	public boolean hasPrior_course_num()
	{
		return _prior_course_num_has;
	}	
	
	private java.lang.String _resp_curric_abbr = null;

	/** resp_curric_abbr **/
	public java.lang.String getResp_curric_abbr()
	{
		return _resp_curric_abbr;
	}	

	private boolean _resp_curric_abbr_has = false;
	
	/** returns true if resp_curric_abbr is non-null **/
	public boolean hasResp_curric_abbr()
	{
		return _resp_curric_abbr_has;
	}	
	
	private short _resp_course_no = 0;

	/** resp_course_no **/
	public short getResp_course_no()
	{
		return _resp_course_no;
	}	

	private boolean _resp_course_no_has = false;
	
	/** returns true if resp_course_no is non-null **/
	public boolean hasResp_course_no()
	{
		return _resp_course_no_has;
	}	
	

	public String toString()
	{
		if( getResultSet() == null )
		{
			return "No results";
		}
		StringBuilder sb = new StringBuilder();
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
		sb.append( "Hyphen_type: " );
		sb.append( getHyphen_type() );
		sb.append( "\n" );
		sb.append( "Prior_dept_abbr: " );
		sb.append( getPrior_dept_abbr() );
		sb.append( "\n" );
		sb.append( "Prior_course_num: " );
		sb.append( getPrior_course_num() );
		sb.append( "\n" );
		sb.append( "Resp_curric_abbr: " );
		sb.append( getResp_curric_abbr() );
		sb.append( "\n" );
		sb.append( "Resp_course_no: " );
		sb.append( getResp_course_no() );
		sb.append( "\n" );
		return sb.toString();
	}
}

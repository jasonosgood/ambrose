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

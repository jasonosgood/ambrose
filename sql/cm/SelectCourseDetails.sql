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

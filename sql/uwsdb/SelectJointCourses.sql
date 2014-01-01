SELECT
	joint_dept_abbrev,
	joint_course_num,
	( last_eff_yr * 10 ) + last_eff_qtr as lastATP
FROM sr_course_titles_joint_course
WHERE department_abbrev = 'E E   '
AND course_number = 510
AND ( last_eff_yr * 10 ) + last_eff_qtr >= 20134
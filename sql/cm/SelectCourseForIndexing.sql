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

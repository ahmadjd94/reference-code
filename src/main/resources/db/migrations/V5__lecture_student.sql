create table lecture_student (
		lecture_id integer references lecture(id),
		student_id integer references student(id)
		);
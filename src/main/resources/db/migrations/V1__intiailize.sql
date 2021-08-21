
create table chair (id serial primary key, material varchar, color varchar);
      
create table student (id serial primary key ,name varchar , major varchar, level varchar, chair_id integer,
	constraint fk_student_chair foreign key (chair_id) references chair(id)); 

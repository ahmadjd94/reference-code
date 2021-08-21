create table teacher (id serial primary key, name varchar, major varchar);

create table lecture (id serial primary key , name varchar , time timestamp, 
						location varchar, capacity integer, teacher_id integer references teacher(id));
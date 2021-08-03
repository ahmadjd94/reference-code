ALTER TABLE students ADD COLUMN level varchar;
update students set level='first';
ALTER TABLE students Alter COLUMN level set default 'first' ;
ALTER TABLE students Alter COLUMN level set not null ;
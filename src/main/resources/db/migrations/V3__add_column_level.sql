update student set level='first';
ALTER TABLE student Alter COLUMN level set default 'first' ;
ALTER TABLE student Alter COLUMN level set not null ;
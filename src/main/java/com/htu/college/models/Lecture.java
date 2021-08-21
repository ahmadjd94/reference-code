package com.htu.college.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="lecture")
public class Lecture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private Date time;
	 
	private String location;
	
	@ManyToMany()
	@JoinTable(name="lecture_student",
			joinColumns=@JoinColumn(name="lecture_id"),
			inverseJoinColumns=@JoinColumn(name="student_id"))
	private List<Student> students; 
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="teacher_id")
    @JsonIgnore
	private Teacher teacher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	public void removeStudent(Student student) {
		this.students.remove(student);
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date date) {
		this.time = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Lecture(Integer id, String name, Date time, String location, Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.location = location;
	}
	public Lecture() {
	}
	
	
	
}

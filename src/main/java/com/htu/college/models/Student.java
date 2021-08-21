package com.htu.college.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//dao
@Entity(name="student")

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //studentID
	private String name; //studentName
	private String major; //studentMajor
	private String level; //studentLevel
	
	@OneToOne()
	@JoinColumn(name="chair_id", referencedColumnName="id")
	private Chair chair;
	
	@ManyToMany()
	@JoinTable(name="lecture_student",
	joinColumns=@JoinColumn(name="student_id"),
	inverseJoinColumns=@JoinColumn(name="lecture_id"))
	@JsonIgnore
	private List<Lecture> Lectures;
	
	@JsonIgnore
	public List<Lecture> getLectures() {
		return Lectures;
	}
	public void setLectures(List<Lecture> lectures) {
		Lectures = lectures;
	}
	public Chair getChair() {
		return chair;
	}
	public void setChair(Chair chair) {
		this.chair = chair;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	

	public Student(Integer id, String name, String major, String level) {
		this.id = id;
		this.name = name;
		this.major = major;
		this.level = level;
	}
	public Student() {

	}
	
	
	
}

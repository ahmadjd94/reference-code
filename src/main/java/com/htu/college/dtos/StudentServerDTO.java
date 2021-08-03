package com.htu.college.dtos;

import com.htu.college.models.Student;

public class StudentServerDTO {
	Integer studentId;
	String studentName;
	String studentMajor;
	String studentLevel;
	
	public static Student studentFromDTO(StudentServerDTO dto) {
		return new Student(
				dto.getStudentId(),
				dto.getStudentName(),
				dto.getStudentMajor(),
				dto.getStudentLevel()
				);
		
	}
	
	
	public static  StudentServerDTO dTOFromStudent(Student dto) {
		return new StudentServerDTO(
				dto.getId(),
				dto.getName(),
				dto.getMajor(),
				dto.getLevel()
				);
		
	}
	
	
	public StudentServerDTO(Integer studentId, String studentName, String studentMajor, String studentLevel) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMajor = studentMajor;
		this.studentLevel = studentLevel;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentMajor() {
		return studentMajor;
	}
	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}
	public String getStudentLevel() {
		return studentLevel;
	}
	public void setStudentLevel(String studentLevel) {
		this.studentLevel = studentLevel;
	}
	
	
}

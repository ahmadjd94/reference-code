package com.htu.college.controllers;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.htu.college.dtos.StudentServerDTO;
import com.htu.college.models.Student;
import com.htu.college.services.StudentService;

@RestController
public class StudentServerController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping(value="/studentsServer/{id}")
	public @ResponseBody StudentServerDTO getStudent(@PathVariable Integer id) {
		return StudentServerDTO.dTOFromStudent(studentService.getStudentById(id));
	}
	
	@GetMapping(value="/studentsServer")
	public @ResponseBody List<StudentServerDTO> getStudents() {
		 return studentService.getAllStudnets()
		 				.stream()
		 				.map(s -> StudentServerDTO.dTOFromStudent(s))
		 				.collect(Collectors.toList());
	}
	
	
	@PostMapping(value="/studentsServer")
	public StudentServerDTO createStudents(@RequestBody StudentServerDTO student) {
		return StudentServerDTO.dTOFromStudent(
				studentService.create(
						StudentServerDTO.studentFromDTO(student)
						)
				);
	}
	
	
	@PutMapping(value="/studentsServer/{id}")
	public StudentServerDTO updateStudents(@PathVariable Integer id,@RequestBody StudentServerDTO studentRequest) {
		return StudentServerDTO.dTOFromStudent(
				studentService.updateStudent(id, 
						StudentServerDTO.studentFromDTO(
						studentRequest)));
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/studentsServer/{id}")
	public void deleteStudents(@PathVariable Integer id) {
		studentService.deleteStudent(id);
		}
	
	
	
	
	
}
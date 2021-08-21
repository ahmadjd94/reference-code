package com.htu.college.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.htu.college.dtos.StudentServerDTO;
import com.htu.college.models.Student;
import com.htu.college.repositories.StudentRepo;
import com.htu.college.services.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping(value="/students/{id}")
	public @ResponseBody Student getStudent(@PathVariable Integer id) {
		return studentService.getStudentById(id);
	}
	

	@GetMapping(value="/students")
	public ResponseEntity<?> getStudents(@RequestHeader("x-client-type") Optional<String> clientType) {
		System.out.println(clientType);
		List<Student> studentList = studentService.getAllStudnets();
		
		if (clientType.isPresent()) {
			if (clientType.get().equals("SERVER")){
				return  ResponseEntity.accepted().body( studentList
					.stream()
					.map(s -> StudentServerDTO.dTOFromStudent(s))
					.collect(Collectors.toList()));
			}
		}
		return ResponseEntity.accepted().body(studentList);
		
	}
	
	@PostMapping(value="/students")
	public Student createStudents(@RequestBody Student student) {
		return studentService.create(student);
	}
	
	@PutMapping(value="/students/{id}")
	public Student updateStudents(@PathVariable Integer id,@RequestBody Student studentRequest) {
		return studentService.updateStudent(id, studentRequest);
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/students/{id}")
	public void deleteStudents(@PathVariable Integer id) {
		studentService.deleteStudent(id);
		}
}

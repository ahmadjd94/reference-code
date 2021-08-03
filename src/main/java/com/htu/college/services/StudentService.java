package com.htu.college.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.htu.college.models.Student;
import com.htu.college.repositories.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepo;
	
	
	public Student getStudentById(Integer id) {
		 Optional<Student> studentOptional= studentRepo.findById(id);
			if (studentOptional.isPresent()) {
				return studentOptional.get();
			}
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "Student Not Found");
	}
	
	public List<Student> getAllStudnets(){
		return studentRepo.findAll();
	}
	public Student create(Student student) {
		return studentRepo.save(student);
	}
	
	public Student updateStudent(Integer id,Student studentRequest) {
		Optional<Student> studentOptional = studentRepo.findById(id);
		if (studentOptional.isPresent()) {
			Student studentObj = studentOptional.get();
			studentObj.setMajor(studentRequest.getMajor());
			studentObj.setName(studentRequest.getName());
			studentObj.setLevel(studentRequest.getLevel());
			studentRepo.save(studentObj);
			return studentObj;
		}
		throw new ResponseStatusException(
		          HttpStatus.NOT_FOUND, "Student Not Found");
	}
	
	public void deleteStudent(Integer id) {
		Optional<Student> entity = studentRepo.findById(id);
		if (entity.isPresent()) {
			studentRepo.deleteById(id);
		}
		else {
			throw new ResponseStatusException(
		          HttpStatus.NOT_FOUND, "Student Not Found");
		}
	}
	
}

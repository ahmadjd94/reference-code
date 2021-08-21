package com.htu.college.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.htu.college.models.Teacher;
import com.htu.college.repositories.TeacherRepo;

@Service
public class TeacherService {
	@Autowired 
	private TeacherRepo teacherRepo;
	
	
	public Teacher getTeacherById(Integer Id) {
		
		Optional<Teacher> teacherOp = teacherRepo.findById(Id);
		
		if(teacherOp.isPresent()) {
			return teacherOp.get();
		}
		throw new ResponseStatusException(
		          HttpStatus.NOT_FOUND, "Teacher Not Found");
	}
}

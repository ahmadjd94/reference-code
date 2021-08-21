package com.htu.college.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.htu.college.models.Teacher;
import com.htu.college.services.TeacherService;

@RestController
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
		
	@GetMapping(value="/teacher/{id}")
	public @ResponseBody Teacher getTeacherById(@PathVariable Integer id) {
		return teacherService.getTeacherById(id);
	}
	
}

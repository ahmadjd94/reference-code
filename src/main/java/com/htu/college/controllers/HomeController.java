package com.htu.college.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.htu.college.models.Lecture;
import com.htu.college.models.Student;
import com.htu.college.services.LectureService;
import com.htu.college.services.StudentService;

@Controller
public class HomeController {
	@Autowired
	StudentService studentService;
	
	@Autowired
	LectureService lectureService;
	
	@GetMapping("/home")
	public String home(Model model) {
		List<Student> s =  studentService.getAllStudnets();
		model.addAttribute("students", s);
		return "home";
	}
	
	@GetMapping("/student")
	public String createStudent(Model model) {
		Student s = new Student();
		model.addAttribute("student", s);
			return "studentSignup";
	}
	
	@GetMapping("/student-with-details/{studentId}")
	public String getStudentWithDetails(@PathVariable Integer studentId,Model model) {
		Student s = studentService.getStudentById(studentId);
		model.addAttribute("student", s);
			return "studentWithDetails";
	}
	
	
	
	@PostMapping("/create-student")
	public String createStudentResponse(Student student) {
		studentService.create(student);
		return "studentCreationSuccessful";
	}
	
	@GetMapping("/delete-student/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudent(id);
		return "deletedStudent";
	}
	
	@GetMapping("/edit-student/{id}")
	public String editStudent(Model model,@PathVariable Integer id) {
		Student student= studentService.getStudentById(id);
		model.addAttribute("student",student);
		
		return "editStudent";
	}
	

	@PostMapping("/update-student/{id}")
	public String updateStudent(@PathVariable Integer id,Student student) {
		studentService.updateStudent(id,student);
		return "studentUpdateSuccessful";
	}
	
	
	@GetMapping("delete-student-from-lecture/{studentId}/lecture/{lectureId}")
	public String deleteStudent(@PathVariable Integer studentId,@PathVariable Integer lectureId) {
		lectureService.deleteStudentfromLecture(studentId,lectureId);
		return "deletedStudentfromLecture";
	}
	
	

	@GetMapping("subscribe/{studentId}")
	public String subscribeStudent(Model model,@PathVariable Integer studentId) {
		List<Lecture> lectures = lectureService.getAllLectures();
		model.addAttribute("studentId",studentId);
		model.addAttribute("lectures",lectures);
		return "subscribe";
	}
	
	
	@PostMapping("subscribe-resp/{studentId}")
	public String subscribeStudent(Lecture lecture) {

		System.out.print(lecture);
		return "subscribe";
	}
	
}

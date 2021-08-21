package com.htu.college.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.htu.college.dtos.StudentLectureDTO;
import com.htu.college.models.Lecture;
import com.htu.college.services.LectureService;

@RestController
public class LectureController {
	@Autowired
	private LectureService lectureService;
	
	@GetMapping(value="/teacher/{id}/lectures")
	public @ResponseBody List<Lecture> getLecturesByTeacherId(@PathVariable Integer id) {
		return  lectureService.getLecturesByTeacherId(id);
	}
	
	@PostMapping(value="/teacher/{teacherId}/lectures")
	public @ResponseBody Lecture createLectureForTeacher(@PathVariable Integer teacherId,@RequestBody Lecture lecture) {
		return lectureService.createLecture(teacherId,lecture);
	}
	
	@PutMapping(value="/lecture/{lectureId}")
	public @ResponseBody Lecture addStudentOnLecture(@PathVariable Integer lectureId,@RequestBody StudentLectureDTO studentId) {
		return lectureService.addStudentToLecture(studentId.getStudentId(),lectureId);
	}
	
	@DeleteMapping(value="/lecture/{lectureId}/{studentId}")
	public void deleteStudentfromLecture(@PathVariable Integer lectureId,@PathVariable Integer studentId) {
		lectureService.deleteStudentfromLecture(studentId,lectureId);
	}
	
	
	
	
}	

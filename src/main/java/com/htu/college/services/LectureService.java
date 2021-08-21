package com.htu.college.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.htu.college.models.Lecture;
import com.htu.college.models.Student;
import com.htu.college.models.Teacher;
import com.htu.college.repositories.LectureRepo;

@Service
public class LectureService {
	@Autowired
	private LectureRepo lectureRepo;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	public List<Lecture> getLecturesByTeacherId(Integer id){
		return lectureRepo.findByTeacherId(id);
	}
	
	public List<Lecture> getAllLectures(){
		return lectureRepo.findAll();
	}
	
	
	public Lecture addStudentToLecture(Integer studentId ,Integer lectureId){
		Optional<Lecture> lectureOptional =  lectureRepo.findById(lectureId);
		
		if (lectureOptional.isPresent()) {
			Lecture lecture= lectureOptional.get();
			Student student = studentService.getStudentById(studentId );
			lecture.addStudent(student);
			return lectureRepo.save(lecture);
		}
		throw new ResponseStatusException(
		          HttpStatus.NOT_FOUND, "Lecture Not Found");
		
		
	}
	
	
	public Lecture deleteStudentfromLecture(Integer studentId ,Integer lectureId){
		Optional<Lecture> lectureOptional =  lectureRepo.findById(lectureId);
		
		if (lectureOptional.isPresent()) {
			Lecture lecture= lectureOptional.get();
			Student student = studentService.getStudentById(studentId );
			lecture.removeStudent(student);
			return lectureRepo.save(lecture);
		}
		throw new ResponseStatusException(
		          HttpStatus.NOT_FOUND, "Lecture Not Found");
		
		
	}
	
	
	public Lecture createLecture(Integer teacherId,Lecture lecture) {
		Teacher teacher= teacherService.getTeacherById(teacherId);
		lecture.setTeacher(teacher);
		return lectureRepo.save(lecture);	
	}
}

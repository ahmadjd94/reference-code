package com.htu.college.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.htu.college.models.Lecture;


public interface LectureRepo  extends CrudRepository<Lecture, Integer>{
	public List<Lecture> findByTeacherId(Integer id);
	public List<Lecture> findAll();
}

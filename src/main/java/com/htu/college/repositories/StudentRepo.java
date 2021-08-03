package com.htu.college.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.htu.college.models.Student;

public interface StudentRepo  extends CrudRepository<Student, Integer> {
	public List<Student> findAll();
	public List<Student> findAllByMajor(String major);

}

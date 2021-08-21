package com.htu.college.repositories;

import org.springframework.data.repository.CrudRepository;

import com.htu.college.models.Teacher;

public interface TeacherRepo extends CrudRepository<Teacher, Integer> {

}

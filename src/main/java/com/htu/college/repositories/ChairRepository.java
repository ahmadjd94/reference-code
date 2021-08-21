package com.htu.college.repositories;

import org.springframework.data.repository.CrudRepository;

import com.htu.college.models.Chair;

public interface ChairRepository extends CrudRepository<Chair, Integer>{
	
}
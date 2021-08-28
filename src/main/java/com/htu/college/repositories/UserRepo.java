package com.htu.college.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htu.college.models.User;

@Repository 
public interface UserRepo extends CrudRepository<User,Integer>{
	Optional<User> findByUsername(String username);
}

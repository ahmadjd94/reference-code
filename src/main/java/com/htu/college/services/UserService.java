package com.htu.college.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.htu.college.models.User;
import com.htu.college.repositories.UserRepo;

@Service
public class UserService {
@Autowired
private UserRepo userRepo;

	public User getUserByUsername(String username) {
		Optional<User> userOptional = userRepo.findByUsername(username);
		if (userOptional.isPresent()) {
			return userOptional.get();
		}
		throw new ResponseStatusException(
		          HttpStatus.NOT_FOUND, "User Not Found");
	}
	
	public boolean authenticateUser(String username,String password) {
		User user = getUserByUsername(username);
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
}

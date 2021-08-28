package com.htu.college.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htu.college.dtos.AuthenticateDTO;
import com.htu.college.models.User;
import com.htu.college.services.UserService;

@RestController
public class AuthenticationController {
	@Autowired
	public UserService userService;
	
	@PostMapping("/auth")
	public String  authenticate(@RequestBody AuthenticateDTO authDTO) {
		if (userService.authenticateUser(authDTO.getUsername(), authDTO.getPassword())){
			return "SUCCESS";
		}
		return "FALSE";
	}
}

package com.htu.college.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htu.college.models.Chair;
import com.htu.college.repositories.ChairRepository;

@Service
public class ChairService {
	@Autowired
	private ChairRepository chairRepo;
	
	public Chair createChair(Chair chair) {
		return chairRepo.save(chair);
	}
}

package com.tdavis.be.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdavis.be.entity.User;
import com.tdavis.be.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Iterable<User> findAll () {
		
		return userRepository.findAll();
		
	}
	
}

package com.gtec.UserAuthApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtec.UserAuthApp.model.User;
import com.gtec.UserAuthApp.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
	}
	
	
	
	
	
	
	
}

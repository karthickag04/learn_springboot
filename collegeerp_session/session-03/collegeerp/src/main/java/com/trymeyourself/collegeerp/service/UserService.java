package com.trymeyourself.collegeerp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trymeyourself.collegeerp.entity.User;
import com.trymeyourself.collegeerp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	
	
	
	
	
	public void saveUser(User user) {

        userRepository.save(user);

    }
	
	
	 public User loginUser(String username, String password){

		 return userRepository.findByUsernameAndPassword(username,password);

	 }

}

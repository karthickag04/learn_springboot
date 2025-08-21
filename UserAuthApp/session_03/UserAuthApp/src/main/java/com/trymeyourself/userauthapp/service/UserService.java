package com.trymeyourself.userauthapp.service;

import org.springframework.stereotype.Service;

import com.trymeyourself.userauthapp.model.User;


public interface UserService {
	
	void saveUser(User user);
	User authenticate(String usernameOrEmail, String password);

}

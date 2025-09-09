package com.trymeyourself.userauthapp.service;

import java.util.List;

import com.trymeyourself.userauthapp.model.User;


public interface UserService {
	
	void saveUser(User user);
	User authenticate(String usernameOrEmail, String password);
	 List<User> findAllUsers();  
	 
	 void deleteUser(Long id);
	 
	 User findById(Long id);

}

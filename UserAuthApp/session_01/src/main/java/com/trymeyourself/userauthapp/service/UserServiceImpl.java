package com.trymeyourself.userauthapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trymeyourself.userauthapp.model.User;
import com.trymeyourself.userauthapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
    public void saveUser(User user) {
		
		userRepo.save(user);
        
    }

}

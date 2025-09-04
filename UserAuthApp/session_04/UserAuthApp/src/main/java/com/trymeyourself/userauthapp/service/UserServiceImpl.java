package com.trymeyourself.userauthapp.service;

import java.util.List;
import java.util.Optional;

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
	
	@Override
	public User authenticate(String usernameOrEmail, String password) {
		
		 Optional<User> userOpt = userRepo.findByEmail(usernameOrEmail);
		 
		 
	        if (userOpt.isEmpty()) {
	            userOpt = userRepo.findByUsername(usernameOrEmail);
	        }
//
	        if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
	            return userOpt.get();
	        }
	        return null;
		
	}
	
	
	@Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

}

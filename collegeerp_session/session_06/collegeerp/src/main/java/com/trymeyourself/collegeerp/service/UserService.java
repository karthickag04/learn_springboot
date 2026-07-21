package com.trymeyourself.collegeerp.service;

import java.util.List;
import java.util.Optional;

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
	 
	 
	 
	 public List<User> getAllUsers(){

		    return userRepository.findAll();

		}
	 
	 
	 public void deleteUser(int id){

		    userRepository.deleteById(id);

		}
	 
	 
	 public User getUserById(int id){

		 
		    Optional<User> optional =
		            userRepository.findById(id);

		    return optional.orElse(null);

		}

	 
	 
	 
}

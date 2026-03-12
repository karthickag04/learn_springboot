package com.trymeyourself.foodapperp01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trymeyourself.foodapperp01.model.User;
import com.trymeyourself.foodapperp01.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    
    
    
    public List<User> getAllUsers()
    {
        return repo.findAll();
    }
    
    
    public User getUserById(int id)
    {
        return repo.findById(id).orElse(null);
    }
    
    public void deleteUser(int id)
    {
        repo.deleteById(id);
    }
    
    

    public boolean authenticate(String email,String password)
    {
        User user = repo.findByEmailAndPassword(email,password);

        if(user != null)
        {
            return true;
        }

        return false;
    }
    
    
    
    public boolean register(User user)
	{
		User existingUser = repo.findByEmailAndPassword(user.getEmail(), user.getPassword());

		if(existingUser != null)
		{
			return false;
		}

		repo.save(user);
		return true;
	}
}
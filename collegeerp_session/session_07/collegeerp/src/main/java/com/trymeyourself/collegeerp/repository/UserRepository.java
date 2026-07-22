package com.trymeyourself.collegeerp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trymeyourself.collegeerp.entity.User;

public interface UserRepository extends  JpaRepository<User, Integer> {
	
	User findByUsernameAndPassword(String username,
            String password);
	
	

}

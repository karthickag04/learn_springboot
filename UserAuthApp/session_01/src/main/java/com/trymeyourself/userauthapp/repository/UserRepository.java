package com.trymeyourself.userauthapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trymeyourself.userauthapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	
}

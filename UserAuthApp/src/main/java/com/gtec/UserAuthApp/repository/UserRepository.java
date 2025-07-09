package com.gtec.UserAuthApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtec.UserAuthApp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	boolean existedByEmail(String Email);
	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);


}

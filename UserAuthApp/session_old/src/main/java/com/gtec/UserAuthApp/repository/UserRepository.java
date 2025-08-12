package com.gtec.UserAuthApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gtec.UserAuthApp.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	boolean existsByEmail(String Email);
	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);


}

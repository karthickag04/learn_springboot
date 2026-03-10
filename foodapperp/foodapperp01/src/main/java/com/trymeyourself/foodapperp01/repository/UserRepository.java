package com.trymeyourself.foodapperp01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trymeyourself.foodapperp01.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}

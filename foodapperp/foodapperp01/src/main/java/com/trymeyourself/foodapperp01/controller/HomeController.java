package com.trymeyourself.foodapperp01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.trymeyourself.foodapperp01.model.User;
import com.trymeyourself.foodapperp01.repository.UserRepository;
// ctrl + shift + o to import the controller

@Controller
public class HomeController {
	
	@Autowired
    private UserRepository repo;
	
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	

	@GetMapping("/register")
	public String registerPage01() {
		
		
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPage(User user) {
		
		
		repo.save(user);
		return "register";
	}

}

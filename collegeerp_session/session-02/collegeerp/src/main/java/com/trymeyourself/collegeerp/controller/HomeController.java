package com.trymeyourself.collegeerp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trymeyourself.collegeerp.entity.User;
import com.trymeyourself.collegeerp.service.UserService;

// ctrl + shift + o

@Controller
public class HomeController {
	
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String Index() {
		
		return "index";
	}
	
	
	@GetMapping("/register")
	public String RegisterGet() {
		
		return "register";
	}

	
	
	@PostMapping("/register")
	public String RegisterPost(@ModelAttribute User user) {
		
		/*
		 * System.out.println("Username : " + user.getUsername());
		 * 
		 * System.out.println("Password : " + user.getPassword());
		 * 
		 * System.out.println("Email : " + user.getEmail());
		 */
		
		 userService.saveUser(user);

		
		return "register";
	}
}

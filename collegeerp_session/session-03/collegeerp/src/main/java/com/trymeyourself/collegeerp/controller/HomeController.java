package com.trymeyourself.collegeerp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trymeyourself.collegeerp.entity.User;
import com.trymeyourself.collegeerp.service.UserService;

// ctrl + shift + o

@Controller
public class HomeController {
	
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	
	@GetMapping("/register")
	public String registerGet() {
		
		return "register";
	}

	
	
	@PostMapping("/register")
	public String registerPost(@ModelAttribute User user) {
		
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
	
	
	@GetMapping("/login")
	public String loginGet() {
		
		return "login";
	}
	
	
	@PostMapping("/login")
	public String loginPost(@RequestParam String username, @RequestParam String password) {
		
		/*
		 * System.out.println("Username : " + user.getUsername());
		 * 
		 * System.out.println("Password : " + user.getPassword());
		 * 
		 * System.out.println("Email : " + user.getEmail());
		 */
		
		User user = userService.loginUser(username,password);

		if(user!=null){

		    return "welcome";

		}

		return "login";
	}
	
}

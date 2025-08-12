package com.trymeyourself.userauthapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trymeyourself.userauthapp.model.User;
import com.trymeyourself.userauthapp.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String IndexPage() {
		return "index";
	}

	@GetMapping("/register")
	public String RegisterPage() {
		return "register";
	}
	
	@GetMapping("/login")
	public String LoginPage() {
		return "login";
	}
	
	@PostMapping("/register")
	public String RegisterPagePost(@ModelAttribute User user) {
				
		userService.saveUser(user);
		
		return "redirect:/login";
	}

	
	
}

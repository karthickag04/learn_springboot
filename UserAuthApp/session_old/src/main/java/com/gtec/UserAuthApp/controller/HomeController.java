package com.gtec.UserAuthApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gtec.UserAuthApp.model.User;
import com.gtec.UserAuthApp.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String IndexPage() {
		return "Index";
	}
	
	@GetMapping("/register")
	public String RegisterPage() {
		return "Register";
	}
	
	@GetMapping("/login")
	public String LoginPage() {
		return "Login";
	}
	
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("user") User user)
	{
		userService.saveUser(user);
		return "redirect:/login";
		
	}
	


}

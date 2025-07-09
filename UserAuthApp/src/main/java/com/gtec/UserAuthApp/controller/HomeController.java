package com.gtec.UserAuthApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
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
	


}

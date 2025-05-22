package com.gtec.website.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/index")
	public String Index() {
		return "Welcome to Spring Web";
	}
	
	

}

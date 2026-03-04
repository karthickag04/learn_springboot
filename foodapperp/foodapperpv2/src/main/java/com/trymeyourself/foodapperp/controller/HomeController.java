package com.trymeyourself.foodapperp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//ctrl + shift + o to import the restcontroller

@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/about")
	public String aboutPage() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String contactPage() {
		return "contact";
	}

}

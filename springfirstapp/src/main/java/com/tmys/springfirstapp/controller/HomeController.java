package com.tmys.springfirstapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/","index"})
	public String HomePage() {
		return "index";
		
	}
	
	

	@GetMapping("/service")
	public String ServicePage() {
		return "services";
		
	}
	
	@GetMapping("/about")
	public String AboutusPage() {
		return "aboutus";
		
	}

}

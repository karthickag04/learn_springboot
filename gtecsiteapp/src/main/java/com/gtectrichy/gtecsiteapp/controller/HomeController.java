package com.gtectrichy.gtecsiteapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/Index"})
	public String IndexPage() {
		return "Index";
	}
	
	@GetMapping("/About")
	public String AboutPage() {
		return "About";
	}

}

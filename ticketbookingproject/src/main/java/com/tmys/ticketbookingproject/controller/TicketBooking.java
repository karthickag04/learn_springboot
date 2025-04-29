package com.tmys.ticketbookingproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;

@Controller
public class TicketBooking {
	
	@GetMapping("/")
	public String IndexPage(Model model) {
		List<String> items = Arrays.asList("Apple", "Banana", "Orange", "Mango");
        model.addAttribute("fruits", items); // Passing the list to JSP
        return "index";
	}

}

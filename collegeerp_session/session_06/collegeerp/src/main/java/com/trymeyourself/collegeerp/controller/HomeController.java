package com.trymeyourself.collegeerp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trymeyourself.collegeerp.entity.User;
import com.trymeyourself.collegeerp.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

// ctrl + shift + o

@Controller
public class HomeController {
	
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String index(HttpServletRequest request) {
		
		String username="Ramesh";
		request.setAttribute("uname", username);
		
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
	public String loginPost(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		
		/*
		 * System.out.println("Username : " + user.getUsername());
		 * 
		 * System.out.println("Password : " + user.getPassword());
		 * 
		 * System.out.println("Email : " + user.getEmail());
		 */
		
		User user = userService.loginUser(username,password);

		if(user!=null){
			
			 List<User> users = userService.getAllUsers();

		        request.setAttribute("user_info", users);

		    return "welcome";

		}

		return "login";
	}
	
	
	
	@GetMapping("/delete")
	public String deleteGet(@RequestParam int id,HttpServletRequest request) {
		
		
		userService.deleteUser(id);
		
		 List<User> users = userService.getAllUsers();

	        request.setAttribute("user_info", users);
		
		return "welcome";
	}
	
	
	@GetMapping("/edit")
	public String editGet(@RequestParam int id, HttpServletRequest request) {
		
		User user =
	            userService.getUserById(id);
		request.setAttribute("user_data", user);
		
		
		return "createuser";
		
	}
	
	
	
	@PostMapping("/edit")
	public String editPost(@ModelAttribute User user, HttpServletRequest request) {
		
		
		userService.saveUser(user);
		
	    List<User> users =
	            userService.getAllUsers();

	    request.setAttribute("user_info", users);
		
		return "welcome";
		
	}
	
}

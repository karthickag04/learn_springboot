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
		
		String username="User";
		request.setAttribute("uname", username);
		
		return "index";
	}
	
	
	@GetMapping("/register")
	public String registerGet() {
		
		return "register";
	}
	
	
	@GetMapping("/admin")
	public String adminGet(HttpServletRequest request) {
		
		List<User> users = userService.getAllUsers();
		 request.setAttribute("user_info", users);
		 
		
		
		return "admindashboard";
	}

	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {

	    request.getSession().invalidate();

	    return "redirect:/";
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

		
		return "login";
	}
	
	
	@GetMapping("/login")
	public String loginGet(HttpServletRequest request) {
		
		
		 User loggedUser = (User) request.getSession().getAttribute("loggedUser");

		    if (loggedUser != null) {

		        if ("ADMIN".equalsIgnoreCase(loggedUser.getRole())) {
		            return "redirect:/admin";
		        } else {
		            return "redirect:/";
		        }
		    }
		    
		    
		
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
			
			/*
			 * List<User> users = userService.getAllUsers();
			 * 
			 * request.setAttribute("user_info", users);
			 */
			
			request.getSession().setAttribute("loggedUser", user);
			
			 if ("ADMIN".equalsIgnoreCase(user.getRole())) {
				 
				 List<User> users = userService.getAllUsers();
				 request.setAttribute("user_info", users);
				 
				 return "admindashboard";
				 
			 }
			 else {
				 
				 request.setAttribute("uname", user.getUsername());
				 
				 return "index";
				 
				 
			 }
			
		   

		}
		
		

		return "login";
	}
	
	
	
	@GetMapping("/delete")
	public String deleteGet(@RequestParam int id,HttpServletRequest request) {
		
		
		userService.deleteUser(id);
		
		 List<User> users = userService.getAllUsers();

	        request.setAttribute("user_info", users);
		
		return "admindashboard";
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
		
		return "admindashboard";
		
	}
	
}

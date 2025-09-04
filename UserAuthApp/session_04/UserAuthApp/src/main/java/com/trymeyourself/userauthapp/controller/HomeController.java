package com.trymeyourself.userauthapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trymeyourself.userauthapp.model.User;
import com.trymeyourself.userauthapp.service.UserService;

import jakarta.servlet.http.HttpSession;

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
	
	@GetMapping("/admin-dashboard")
	public String AdminDashboardPage(HttpSession session, Model model) {
		
		List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        
		return "admin-dashboard";
	}
	
	@GetMapping("/lib-dashboard")
	public String LibDashboardPage() {
		return "lib-dashboard";
	}
	
	
	@GetMapping("/register-admin")
	public String RegisterAdminPage() {
		return "register-admin";
	}
	
	@GetMapping("/user-dashboard")
	public String DashboardPage() {
		return "user-dashboard";
	}
	
	@GetMapping("/login")
	public String LoginPage() {
		return "login";
	}
	
	@PostMapping("/register")
	public String RegisterPagePost(@ModelAttribute User user) {
//		user.setRole("USER");  // 	
		userService.saveUser(user);
		
		return "redirect:/login";
	}
	
	
	@PostMapping("/register-admin")
	public String RegisterAdminPagePost(@ModelAttribute User user) {
//		user.setRole("Admin");  // 	
		userService.saveUser(user);
		
		return "redirect:/login";
	}
	
	@PostMapping("/login")
    public String loginUser(@RequestParam String usernameOrEmail,
                            @RequestParam String password,
                            HttpSession session) {
        User user = userService.authenticate(usernameOrEmail, password);
        if (user != null) {
            session.setAttribute("user", user);
//            return "redirect:/dashboard";
			if(user.getRole().equals("Admin")) {
				return "redirect:/admin-dashboard";
			}
			else if(user.getRole().equals("LibStaff")) {
				return "redirect:/lib-dashboard";
			}
			
			else {
				return "redirect:/user-dashboard";
			}
        } else {
            return "redirect:/login?error=true";
        }
    }

	
	
}

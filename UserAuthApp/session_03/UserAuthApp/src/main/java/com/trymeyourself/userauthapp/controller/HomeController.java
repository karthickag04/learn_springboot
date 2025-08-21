package com.trymeyourself.userauthapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@GetMapping("/register-admin")
	public String RegisterAdminPage() {
		return "register-admin";
	}
	
	// Save admin
    @PostMapping("/register-admin")
    public String RegisterAdminPagePost(@ModelAttribute User user) {
        user.setRole("ADMIN"); // admin role
        userService.saveUser(user);
        return "redirect:/login";
    }
    
    
    
	
	@GetMapping("/dashboard")
	public String DashboardPage() {
		return "dashboard";
	}

	
	@GetMapping("/admin-dashboard")
	public String AdminDashboardPage() {
		return "admin-dashboard";
	}
	
	@GetMapping("/login")
	public String LoginPage() {
		return "login";
	}
	
	@PostMapping("/register")
	public String RegisterPagePost(@ModelAttribute User user) {
				
		userService.saveUser(user);
		
		return "redirect:/login";
	}
	
	@PostMapping("/login")
    public String loginUser(@RequestParam String usernameOrEmail,
                            @RequestParam String password,
                            HttpSession session) {
        User user = userService.authenticate(usernameOrEmail, password);
//        if (user != null) {  // older implementation
//            session.setAttribute("user", user);
//            return "redirect:/dashboard";
//        } 
        
        
        if (user != null) {
            session.setAttribute("user", user);

            // Role-based redirect
            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/admin-dashboard";
            } 
            
            else if ("LIBRARIAN".equals(user.getRole())) {
                return "redirect:/librarian-dashboard";
            } 
            
            else {
                return "redirect:/dashboard";
            }
        } 
        
        else {
            return "redirect:/login?error=true";
        }
    }
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/login";
	}

	
	
}

package com.tmys.springfirstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tmys.springfirstapp.model.User;
import com.tmys.springfirstapp.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
    private UserService userService;
	
	
    @GetMapping("/")
    public String home() {
        return "index"; // Renders index.jsp
    }

    @GetMapping("/about")
    public String AboutPage() {
        return "aboutus"; // Renders about.jsp
    }
    
    @GetMapping("/services")
    public String ServicePage() {
        return "services"; // Renders about.jsp
    }
    
    
    @GetMapping("/login")
    public String LoginPage() {
        return "login"; // Renders about.jsp
    }
    
    @GetMapping("/register")
    public String RegisterPage() {
        return "register"; // Renders about.jsp
    }
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
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
            return "redirect:/dashboard";
        } else {
            return "redirect:/login?error=true";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "dashboard"; // Add dashboard.jsp if needed
        }
        return "redirect:/login";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    }
package com.trymeyourself.foodapperp01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trymeyourself.foodapperp01.model.User;
import com.trymeyourself.foodapperp01.repository.UserRepository;
import com.trymeyourself.foodapperp01.service.UserService;
// ctrl + shift + o to import the controller

@Controller
public class HomeController {

	@Autowired
	private UserRepository repo;

	@Autowired
	private UserService service;

	@GetMapping("/")
	public String indexPage(Model model) {
		
		List<User> users = service.getAllUsers();
        model.addAttribute("users", users);
        
		return "index";
	}

	@GetMapping("/register")
	public String registerPage01() {

		return "register";
	}

	@GetMapping("/login")
	public String loginPage01() {

		return "login";
	}

	@PostMapping("/login")
	public String loginPostPage01(@RequestParam String email, @RequestParam String password,Model model) {

		boolean status = service.authenticate(email, password);

		if (status) {
			
			List<User> users = service.getAllUsers();
	        model.addAttribute("users", users);
			
			return "index";
		} else {
			return "login";
		}

	}

	@PostMapping("/register")
	public String registerPage(User user) {

		boolean status = service.register(user);
		if (status) {
			return "login";
		}
		
		return "register";
	}
	
	
    // Delete user
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id)
    {
        service.deleteUser(id);
        return "redirect:/index";
    }

    // Edit page
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable int id, Model model)
    {
        User user = service.getUserById(id);
        model.addAttribute("user", user);

        return "edit-user";
    }

}

package com.tmys.springfirstapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // Renders index.jsp
    }

    @GetMapping("/about")
    public String about() {
        return "about"; // Renders about.jsp
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact"; // Renders contact.jsp
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        // Add logic to fetch students
        return "students"; // Renders students.jsp
    }
}
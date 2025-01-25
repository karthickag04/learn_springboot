package com.tmys.schoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	// Map GET request to "/index" URL
    @GetMapping({"/", "/index"})
    public String showIndex() {
        // Return the name of the JSP view (without the .jsp extension)
        return "index";
    }
    
 // Map GET request to "/about us" URL
    @GetMapping("/aboutus")
    public String showAboutus() {
        // Return the name of the JSP view (without the .jsp extension)
        return "aboutus";
    }
    
}

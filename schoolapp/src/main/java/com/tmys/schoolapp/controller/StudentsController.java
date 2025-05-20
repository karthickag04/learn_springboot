package com.tmys.schoolapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmys.schoolapp.model.Student;
import com.tmys.schoolapp.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public String registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }
    
    @GetMapping("/msg")
    public String getMessage() {
		return "Hello from StudentsController!";
	}
    
    
}
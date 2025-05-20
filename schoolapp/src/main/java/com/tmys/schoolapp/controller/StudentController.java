package com.tmys.schoolapp.controller;

import com.tmys.schoolapp.model.Student;
import com.tmys.schoolapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping({"/","/students"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(HttpSession session,Model model) {
    	
    	Student student = (Student) session.getAttribute("loggedInStudent");
      if (student == null) {
          return "redirect:/";
      }
      model.addAttribute("student", student);
      List<Student> students = studentService.getAllStudents();
      model.addAttribute("students", students);
      return "students";
    }

    @GetMapping("/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create_student";
    }

    @PostMapping("/students/create")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit_student";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setCourse(student.getCourse());

        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
    
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student, Model model) {
        String result = studentService.registerStudent(student);
        if (result.contains("already")) {
            model.addAttribute("error", result);
            return "register";
        }
        model.addAttribute("success", result);
        return "/";
    }

    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("student", new Student());
        return "login";
    }

    @PostMapping
    public String loginStudent(@ModelAttribute Student student, Model model, HttpSession session) {
        Student loggedIn = studentService.login(student.getEmail(), student.getPassword());
        if (loggedIn != null) {
            session.setAttribute("loggedInStudent", loggedIn);
            return "redirect:/students/students";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "/";
        }
    }

//    @GetMapping("/dashboard")
//    public String studentDashboard(HttpSession session, Model model) {
//        Student student = (Student) session.getAttribute("loggedInStudent");
//        if (student == null) {
//            return "redirect:/students/login";
//        }
//        model.addAttribute("student", student);
//        return "dashboard";
//    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
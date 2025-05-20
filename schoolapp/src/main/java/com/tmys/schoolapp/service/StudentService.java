package com.tmys.schoolapp.service;

import com.tmys.schoolapp.model.Student;
import com.tmys.schoolapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
 

 

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    
    
    
    
    public String registerStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            return "Email already registered!";
        }
        studentRepository.save(student);
        return "Student registered successfully!";
    }
    
    public Student login(String email, String password) {
        return studentRepository.findByEmailAndPassword(email, password);
    }

}
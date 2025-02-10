//package com.tmys.schoolapp.service;
//
//import com.tmys.schoolapp.model.Student;
//import com.tmys.schoolapp.repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class StudentServiceImpl implements StudentService {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Override
//    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//    }
//
//    @Override
//    public void saveStudent(Student student) {
//        studentRepository.save(student);
//    }
//
//    @Override
//    public Student getStudentById(Long id) {
//        return studentRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void deleteStudent(Long id) {
//        studentRepository.deleteById(id);
//    }
//}

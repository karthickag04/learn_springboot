package com.tmys.schoolapp.repository;

import com.tmys.schoolapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	boolean existsByEmail(String email);
	Student findByEmailAndPassword(String email, String password);
	Student findByEmail(String email);
}
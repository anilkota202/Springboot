package com.talcott.talcott.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talcott.talcott.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	
	Student findById(int id);

}

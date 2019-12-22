package com.talcott.talcott.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.talcott.talcott.model.Student;
import com.talcott.talcott.repository.StudentRepo;



@RestController 
public class StudentController {
	 
	@Autowired
	private StudentRepo studentrepo;
	
	@GetMapping("/stfindall")
	public List<Student> stmethod()
	{
		return studentrepo.findAll();
	}
	@GetMapping("/stfindid/{id}")
	public Student stfind(@PathVariable("id") int id)
	{
		return studentrepo.findById(id);
	}
	
	@PostMapping("/stsave")
	public String stfind(@RequestBody Student st)
	{
		
		studentrepo.saveAndFlush(st);

		
		return "Sucess";
	}
	
	
	
	

}

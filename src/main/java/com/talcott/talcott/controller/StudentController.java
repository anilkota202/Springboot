package com.talcott.talcott.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.talcott.talcott.ipTest.IPAdressTrack;
import com.talcott.talcott.model.Student;
import com.talcott.talcott.repository.StudentRepo;



@RestController 
public class StudentController {
	
	@Autowired
	private IPAdressTrack IPAdressTrack;
	 
	@Autowired
	private StudentRepo studentrepo;
	
	@GetMapping("/stfindall")
	public List<Student> stmethod(HttpServletRequest request)
	{
		IPAdressTrack.getClientIp();
		
		return studentrepo.findAll();
	}
	@GetMapping("/stfindid/{id}")
	public Student stfind(@PathVariable("id") int id)
	{
		IPAdressTrack.getClientIp();
		return studentrepo.findById(id);
	}
	
	@PostMapping("/stsave")
	public String stfind(@RequestBody Student st)
	{
		IPAdressTrack.getClientIp();
		studentrepo.saveAndFlush(st);

		
		return "Sucess";
	}
	
	
	
	

}

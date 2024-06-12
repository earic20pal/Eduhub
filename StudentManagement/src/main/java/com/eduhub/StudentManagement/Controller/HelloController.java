package com.eduhub.StudentManagement.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduhub.StudentManagement.Model.StudentProfile;
import com.eduhub.StudentManagement.Service.StudentProfileService;


@RestController
@RequestMapping("/student-jpa")
public class HelloController {
	@Autowired
	private StudentProfileService studentProfileService;
	
	@GetMapping
	public List<StudentProfile> getAll() {
		return studentProfileService.getAll();
	}

}


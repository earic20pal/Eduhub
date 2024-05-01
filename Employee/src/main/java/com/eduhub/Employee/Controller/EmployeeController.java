package com.eduhub.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduhub.Employee.Model.Employee;
import com.eduhub.Employee.Service.EmployeeService;
import com.eduhub.Employee.repository.EmployeeRepository;


@RestController
@RequestMapping("/employee-jpa")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

}

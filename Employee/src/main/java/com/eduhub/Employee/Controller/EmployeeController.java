package com.eduhub.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduhub.Employee.Model.Employee;
import com.eduhub.Employee.Service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/Employees")
	public List<Employee> retrieveLimits() {
		return employeeService.findall();
	}


}

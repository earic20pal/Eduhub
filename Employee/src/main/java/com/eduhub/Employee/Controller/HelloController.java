package com.eduhub.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduhub.Employee.Configuration.Configuration;


@RestController
public class HelloController {
	
//	@Autowired
//	private Configuration configuration;
//
//	@GetMapping("/limits")
//	public Limits retrieveLimits() {
//		return new Limits(configuration.getMinimum(), 
//				configuration.getMaximum());
////		return new Limits(1,1000);
//	}

}

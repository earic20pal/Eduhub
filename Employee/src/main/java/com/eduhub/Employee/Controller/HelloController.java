package com.eduhub.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/limit")
	public Limit limit() {
		return new Limit(configuration.getMinimum(), configuration.getMaximum());
	}

}

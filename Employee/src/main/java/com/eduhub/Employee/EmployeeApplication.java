package com.eduhub.Employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.eduhub.Employee.Model.Employee;
import com.eduhub.Employee.repository.EmployeeRepository;
import com.eduhub.Employee.util.HelperUtil;

@SpringBootApplication
@EnableMongoRepositories
public class EmployeeApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired

	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<Employee> employees = employeeRepository.findAll();
			if (employees.size() == 0) {
				LOGGER.info("******* Inserting Employees to DB *******");
				employeeRepository.saveAll(HelperUtil.employeeSupplier.get());
			} else {
				LOGGER.info("******* Employees stored in DB Size :: {}", employees.size());
				LOGGER.info("******* Employees stored in DB :: {}", employees);
			}

		};
	}

}

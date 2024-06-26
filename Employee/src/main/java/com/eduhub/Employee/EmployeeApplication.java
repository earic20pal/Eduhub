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

	private final Logger logger = LoggerFactory.getLogger(getClass());

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
				logger.info("=====inserting data========");
				logger.info("data is ");
				System.out.print("data-------------->"+HelperUtil.EmployeeSupplier.get());
//				employeeRepository.saveAll(HelperUtil.EmployeeSupplier.get());
			} 
		};
	}

}

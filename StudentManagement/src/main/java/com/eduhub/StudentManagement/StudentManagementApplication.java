package com.eduhub.StudentManagement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.eduhub.StudentManagement.Model.StudentProfile;
import com.eduhub.StudentManagement.Repository.StudentProfileRepository;
import com.eduhub.StudentManagement.util.HelperUtil;

@SpringBootApplication
@EnableMongoRepositories
public class StudentManagementApplication {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@Autowired
	private StudentProfileRepository studentProfileRepository ;

	@Autowired
	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<StudentProfile> employees = studentProfileRepository.findAll();
			if (employees.size() == 0) {
				logger.info("=====inserting data========");
				logger.info("data is ");
				System.out.print("data-------------->"+HelperUtil.StudentProfileSupplier.get());
				studentProfileRepository.saveAll(HelperUtil.StudentProfileSupplier.get());
			} 
		};
	}

}

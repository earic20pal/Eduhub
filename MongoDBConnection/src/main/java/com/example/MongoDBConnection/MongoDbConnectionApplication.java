package com.example.MongoDBConnection;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.MongoDBConnection.Model.DocumentNew;
import com.example.MongoDBConnection.Model.DocumentNewRepository;
import com.example.MongoDBConnection.Model.HelperUtil;

@SpringBootApplication
@EnableMongoRepositories
public class MongoDbConnectionApplication {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(MongoDbConnectionApplication.class, args);
	}
	
	@Autowired
	private DocumentNewRepository documentNewRepository;
	
	
	@Autowired
	@Bean
	CommandLineRunner runner(){
		return args -> {
			List<DocumentNew> employees = documentNewRepository.findAll();
			if (employees.size() == 0) {
				logger.info("=====inserting data========");
				logger.info("data is ");
				System.out.print("data-------------->"+HelperUtil.StudentProfileSupplier.get());
				documentNewRepository.saveAll(HelperUtil.StudentProfileSupplier.get());
			} 
		};
		
	}
	

}

package com.eduhub.Employee.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eduhub.Employee.Model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    
   

}
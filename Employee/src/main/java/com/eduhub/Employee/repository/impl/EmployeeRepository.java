package com.eduhub.Employee.repository.impl;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eduhub.Employee.Model.Employee;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Employee findByFirstName(String firstName);

    List<Employee> findByFirstNameLike(String firstName);


}

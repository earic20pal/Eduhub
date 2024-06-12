package com.eduhub.StudentManagement.Repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.eduhub.StudentManagement.Model.StudentProfile;
import com.eduhub.StudentManagement.Repository.StudentProfileQueryDao;

@Repository
public class StudentProfileQueryDaoImpl implements StudentProfileQueryDao {



    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<StudentProfile> getAll() {
        System.out.println("Inside Employee Query DAO Impl's get()");
        return mongoTemplate.findAll(StudentProfile.class);
    }


    @Override
    public List<StudentProfile> getEmployeeByFirstName(String firstName) {

        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is(firstName));
        return new ArrayList<>(mongoTemplate.find(query, StudentProfile.class));
    }


    @Override
    public StudentProfile getSingleEmployeeByFirstName(String name) {

        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is(name));

        return mongoTemplate.findOne(query, StudentProfile.class);
    }


    // "firstName"  --> database property (not related to java code)
    // select * from employee where lastName like %Gurung% limit 1 --> (case insensitive)
    @Override
    public List<StudentProfile> getEmployeeByFirstNameLike(String firstName) {

        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").regex(firstName, "i"));

        return mongoTemplate.find(query, StudentProfile.class);
    }


    @Override
    public StudentProfile getSingleEmployeeByLastName(String lastName) {

        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").regex(lastName, "i"));

        return mongoTemplate.findOne(query, StudentProfile.class);
    }




    @Override
    public List<StudentProfile> getEmployeeBySalaryGreaterThan(int salary) {

        Query query = new Query();
        query.addCriteria(Criteria.where("salary").gt(salary));
        query.with(Sort.by(Sort.Direction.ASC, "firstName"));
        query.with(Sort.by(new Sort.Order(Sort.Direction.ASC, "firstName").ignoreCase()));

        return mongoTemplate.find(query, StudentProfile.class);
    }




}

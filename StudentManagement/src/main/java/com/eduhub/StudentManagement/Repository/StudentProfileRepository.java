package com.eduhub.StudentManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eduhub.StudentManagement.Model.StudentProfile;

public interface StudentProfileRepository extends MongoRepository<StudentProfile, Integer>{

}

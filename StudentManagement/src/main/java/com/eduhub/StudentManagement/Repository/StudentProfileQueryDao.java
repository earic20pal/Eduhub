package com.eduhub.StudentManagement.Repository;

import java.util.List;

import com.eduhub.StudentManagement.Model.StudentProfile;


public interface StudentProfileQueryDao {
	
	List<StudentProfile> getAll();

	List<StudentProfile> getEmployeeByFirstName(String firstName);

	StudentProfile getSingleEmployeeByFirstName(String firstName);

	List<StudentProfile> getEmployeeByFirstNameLike(String firstName);

	StudentProfile getSingleEmployeeByLastName(String lastName);

	List<StudentProfile> getEmployeeBySalaryGreaterThan(int salary);

}

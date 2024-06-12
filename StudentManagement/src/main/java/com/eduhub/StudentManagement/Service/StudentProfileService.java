package com.eduhub.StudentManagement.Service;

import java.util.List;

import com.eduhub.StudentManagement.Model.StudentProfile;

public interface StudentProfileService {

	List<StudentProfile> getAll();

	List<StudentProfile> getEmployeeByFirstName(String firstName);

	StudentProfile getSingleEmployeeByLastName(String lastName);

	List<StudentProfile> getEmployeeByFirstNameLike(String firstName);

	StudentProfile getOneEmployeeByFirstName(String firstName);

	List<StudentProfile> getEmployeeBySalaryGreaterThan(int salary);

	List<StudentProfile> getEmployeeByCondition(StudentProfile employee);
}

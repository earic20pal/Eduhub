package com.eduhub.StudentManagement.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduhub.StudentManagement.Model.StudentProfile;
import com.eduhub.StudentManagement.Repository.StudentProfileQueryDao;
import com.eduhub.StudentManagement.Service.StudentProfileQueryService;

@Service
public class StudentProfileQueryServiceImpl implements StudentProfileQueryService {

		@Autowired
		private StudentProfileQueryDao studentProfileQueryDao;

		@Override
		public List<StudentProfile> getAll() {
			System.out.println("Inside Employee Query Service Impl");
			return studentProfileQueryDao.getAll();
		}

		@Override
		public List<StudentProfile> getEmployeeByFirstName(String firstName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public StudentProfile getSingleEmployeeByLastName(String lastName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<StudentProfile> getEmployeeByFirstNameLike(String firstName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public StudentProfile getOneEmployeeByFirstName(String firstName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<StudentProfile> getEmployeeBySalaryGreaterThan(int salary) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<StudentProfile> getEmployeeByCondition(StudentProfile employee) {
			// TODO Auto-generated method stub
			return null;
		}

//		@Override
//		public List<Employee> getEmployeeByFirstName(String firstName) {
//
//			if (!StringUtils.isEmpty(firstName)) {
//				return employeeQueryDao.getEmployeeByFirstName(firstName);
//			}
//
//			return null;
//		}
//
//
//		@Override
//		public Employee getOneEmployeeByFirstName(String firstName) {
//
//			if (!StringUtils.isEmpty(firstName)) {
//				return employeeQueryDao.getSingleEmployeeByFirstName(firstName);
//			}
//
//			return null;
//		}
//		@Override
//		public List<Employee> getEmployeeByFirstNameLike(String firstName) {
//
//			if (!StringUtils.isEmpty(firstName)) {
//				return employeeQueryDao.getEmployeeByFirstNameLike(firstName);
//			}
//
//			return null;
//		}
//
//
//		@Override
//		public Employee getSingleEmployeeByLastName(String lastName) {
//
//			if (!StringUtils.isEmpty(lastName)) {
//				return employeeQueryDao.getSingleEmployeeByLastName(lastName);
//			}
//			return Employee.builder().empId(0).firstName("Not Found").lastName("Please enter valid last name").salary(0f).build();
//		}
//
//		@Override
//		public List<Employee> getEmployeeBySalaryGreaterThan(int salary) {
//
//			if (salary > 0) {
//				return employeeQueryDao.getEmployeeBySalaryGreaterThan(salary);
//			}
//			return Collections.emptyList();
//		}
//
//		@Override
//		public List<Employee> getEmployeeByCondition(Employee employee) {
//			List<Employee> list = employeeQueryDao.getAll();
//			List<Employee> employees = new ArrayList<>();
//
//			if (null != employee && (null != employee.getFirstName() || employee.getEmpId() > 0
//					|| null != employee.getLastName() || employee.getSalary() > 0)) {
//
//				for (Employee emp : list) {
//
//					if (null != employee.getFirstName() && employee.getEmpId() > 0 && null != employee.getLastName()
//							&& employee.getSalary() > 0) {
//
//						if (emp.getEmpId() == employee.getEmpId()
//								&& emp.getFirstName().equalsIgnoreCase(employee.getFirstName())
//								&& emp.getLastName().equalsIgnoreCase(employee.getLastName())
//								&& emp.getSalary() == employee.getSalary()) {
//							employees.add(emp);
//
//							break;
//						} else {
//							continue;
//						}
//					}
//					if (employee.getEmpId() == emp.getEmpId()) {
//						employees.add(emp);
//						continue;
//					}
//
//					// First name
//					if (null != employee.getFirstName()) {
//						if (emp.getFirstName().toLowerCase().contains(employee.getFirstName().toLowerCase())) {
//							employees.add(emp);
//							// Go back to first statement (nothing but for loop)
//							continue;
//						}
//					}
//
//					// Last name
//					if (null != employee.getLastName()) {
//						if (emp.getLastName().equalsIgnoreCase(employee.getLastName()))
//							employees.add(emp);
//						// Go back to first statement (nothing but for loop)
//						continue;
//					}
//					// salary
//					if (employee.getSalary() == emp.getSalary()) {
//						employees.add(emp);
//					}
//					// ---------------------------------------------------------
//				}
//				// returning the list
//				return employees;
//			}
//			// if below statements return false only then below list is returning
//			// if (null != employee &&
//			// (null != employee.getFirstName() || employee.getEmpId() > 0
//			// || null != employee.getLastName() || employee.getSalary() > 0))
//			return employees;
//		}

	}

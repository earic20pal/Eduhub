package com.eduhub.Employee.Service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduhub.Employee.Model.Employee;
import com.eduhub.Employee.Service.EmployeeService;
import com.eduhub.Employee.repository.EmployeeRepository;

//import com.spring.mongo.demo.model.Employee;
//import com.spring.mongo.demo.repository.EmployeeRepository;
//import com.spring.mongo.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> getAll() {
		List<Employee> list = repository.findAll();
		return list;
	}

	@Override
	public Employee getEmployeeByLastName(String lastName) {

		List<Employee> employees = repository.findAll();

		for (Employee emp : employees) {
			if (emp.getLastName().equalsIgnoreCase(lastName))
				return emp;
		}
		return Employee.builder().empId(0).firstName("Not Found").lastName("Please enter valid id").salary(0f).build();
	}

	@Override
	public Employee getEmployeeById(int empId) {
		List<Employee> employees = repository.findAll();
		for (Employee emp : employees) {
			if (empId == emp.getEmpId())
				return emp;
		}
		return Employee.builder().empId(0).firstName("Not Found").lastName("Please enter valid id").salary(0f).build();
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		List<Employee> employees = new ArrayList<>();
		List<Employee> list = repository.findAll();
		for (Employee emp : list) {
			if (emp.getFirstName().equalsIgnoreCase(firstName))
				employees.add(emp);
		}
		return employees;
	}

	@Override
	public Employee getOneEmployeeByFirstName(String firstName) {
		return repository.findByFirstName(firstName);
	}

	@Override
	public List<Employee> getEmployeeByFirstNameLike(String firstName) {
		return repository.findByFirstNameLike(firstName);
	}

//	@Override
//	public Employee getEmployeeByFirstName(Employee employee) {
//		List<Employee> list = repository.findAll();
//		for (Employee emp : list) {
//			if (emp.getFirstName().equals(employee.getFirstName()))
//				return emp;
//		}
//		return Employee.builder().empId(0).firstName("Not Found").lastName("Please enter valid id").salary(0f).build();
//	}
//
//	@Override
//	public List<Employee> getEmployeeByFrName(Employee employee) {
//		List<Employee> employees = new ArrayList<>();
//
//		if (null != employee && null != employee.getFirstName()
//				&& !(employee.getFirstName().equals(""))) {
//			List<Employee> list = repository.findAll();
//
//			for (Employee emp : list) {
//				if (emp.getFirstName().toLowerCase().contains(employee.getFirstName().toLowerCase())) {
//					employees.add(emp);
//				}
//			}
//		}
//		return employees;
//	}

	@Override
	public List<Employee> getEmployeeBySalaryGreaterThan(int salary) {
		List<Employee> employees = new ArrayList<>();

		if (salary > 0) {
			List<Employee> list = repository.findAll();

			for (Employee emp : list) {
				if (emp.getSalary() > salary)
					employees.add(emp);
			}
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeeByCondition(Employee employee) {
		List<Employee> list = repository.findAll();
		List<Employee> employees = new ArrayList<>();

		// This will return true if employee object is present(not null) any one of
		// property is not null OR greater than 0
		if (null != employee && (null != employee.getFirstName() || employee.getEmpId() > 0
				|| null != employee.getLastName() || employee.getSalary() > 0)) {

			for (Employee emp : list) {

				// If all 4 properties are present then only this block will execute
				if (null != employee.getFirstName() && employee.getEmpId() > 0 && null != employee.getLastName()
						&& employee.getSalary() > 0) {

					if (emp.getEmpId() == employee.getEmpId()
							&& emp.getFirstName().equalsIgnoreCase(employee.getFirstName())
							&& emp.getLastName().equalsIgnoreCase(employee.getLastName())
							&& emp.getSalary() == employee.getSalary()) {
						employees.add(emp);
						// Break the for loop
						break;
					} else {
						// Go back to first statement
						continue;
					}
				}

				// if any one of above property is null or less than equals to 0 then below
				// block is executing
				// Emp Id
				if (employee.getEmpId() == emp.getEmpId()) {
					employees.add(emp);
					// Go back to first statement
					continue;
				}

				// First name
				if (null != employee.getFirstName()) {
					if (emp.getFirstName().toLowerCase().contains(employee.getFirstName().toLowerCase())) {
						employees.add(emp);
						// Go back to first statement
						continue;
					}
				}

				// Last name
				if (null != employee.getLastName()) {
					if (emp.getLastName().equalsIgnoreCase(employee.getLastName()))
						employees.add(emp);
					// Go back to first statement
					continue;
				}
				// salary
				if (employee.getSalary() == emp.getSalary()) {
					employees.add(emp);
				}
				// ---------------------------------------------------------
			}
			// returning the list
			return employees;
		}
		// if below statements return false only then below list is returning
		// if (null != employee &&
		// (null != employee.getFirstName() || employee.getEmpId() > 0
		// || null != employee.getLastName() || employee.getSalary() > 0))
		return employees;
	}

	public String upload() {

		  try {
		   String filename = "C:\\Users\\Admin\\OneDrive\\Desktop\\exceldatabase.xlsx";
		   try (FileInputStream file = new FileInputStream(new File(filename))) {
		    Workbook workbook = WorkbookFactory.create(file);
		    Sheet sheet = workbook.getSheetAt(0);
		    Row row;
		    System.out.println("last row number is=========" + sheet.getLastRowNum());
		    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		     row = sheet.getRow(i);
		     int empId = (int)(row.getCell(0).getNumericCellValue());
		     String firstName = row.getCell(1).getStringCellValue();
		     String lastName = row.getCell(2).getStringCellValue();
		     float salary = (float) row.getCell(3).getNumericCellValue();
			 int positionId = (int) row.getCell(4).getNumericCellValue();
			 Employee emp = new Employee();
			 emp.builder().empId(empId).firstName(firstName).lastName(lastName).salary(salary).positionId(positionId).build();
		     repository.save(emp);
			 System.out.println("Records inserted.........." + i);
		    }
		    System.out.println("");
		   }
		  } catch (Exception e) {
		 }

	return null;
}

}

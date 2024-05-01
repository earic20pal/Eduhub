package com.eduhub.Employee.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document("Employee")
@Data
@Builder
public class Employee {

	@Id
	private String id;
	private String userid;
	private String jobTitleName;
	private String firstName;
	private String lastName;
	private String preferredFullName;
	private String employeeCode;
	private String region;
	private String phoneNumber;
	private String emailAddress;

	public Employee(String id, String userid, String jobTitleName, String firstName, String lastName,
			String preferredFullName, String employeeCode, String region, String phoneNumber, String emailAddress) {
		super();
		this.id = id;
		this.userid = userid;
		this.jobTitleName = jobTitleName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.preferredFullName = preferredFullName;
		this.employeeCode = employeeCode;
		this.region = region;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getJobTitleName() {
		return jobTitleName;
	}

	public void setJobTitleName(String jobTitleName) {
		this.jobTitleName = jobTitleName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPreferredFullName() {
		return preferredFullName;
	}

	public void setPreferredFullName(String preferredFullName) {
		this.preferredFullName = preferredFullName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}

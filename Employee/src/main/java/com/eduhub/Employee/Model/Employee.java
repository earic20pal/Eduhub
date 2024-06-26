package com.eduhub.Employee.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee implements Serializable {

	@Id
	private String id;
	
	private int empId;
	private String firstName;
	private String lastName;
	private float salary;
	private String position;
	private int positionId;
	

}

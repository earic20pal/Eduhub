package com.eduhub.StudentManagement.Model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "StudentProfile")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentProfile implements Serializable {
	@Id
	private String id;
	private int studentProfileId;
	private String firstName;
	private String lastName;
	private float salary;
	private String position;
	private int positionId;
}

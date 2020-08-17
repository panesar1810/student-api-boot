package code.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Student {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;
	
	private String firstName;
	
	private String lastName;
	
	private String course;
	
	private String program;

	private String age;
	
	private String gender;

	public Student(String firstName, String lastName, String course,
			String program, String age, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.program = program;
		this.age = age;
		this.gender = gender;
	}

}

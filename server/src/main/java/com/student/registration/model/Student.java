package com.student.registration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student" )
public class Student {

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";



	@Id
	private long id;


	private String name;
	private String dateOfBirth;
	private String dobDay;
	private String dobMonth;
	private String dobYear;
	private String grade;
	private String division;
	private String gender;
	private String rollNumber;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long id, String name, String dateOfBirth, String dobDay, String dobMonth, String dobYear,
			String grade, String division, String gender, String rollNumber) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.dobDay = dobDay;
		this.dobMonth = dobMonth;
		this.dobYear = dobYear;
		this.grade = grade;
		this.division = division;
		this.gender = gender;
		this.rollNumber = rollNumber;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDobDay() {
		return dobDay;
	}
	public void setDobDay(String dobDay) {
		this.dobDay = dobDay;
	}
	public String getDobMonth() {
		return dobMonth;
	}
	public void setDobMonth(String dobMonth) {
		this.dobMonth = dobMonth;
	}
	public String getDobYear() {
		return dobYear;
	}
	public void setDobYear(String dobYear) {
		this.dobYear = dobYear;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	
	
}

	


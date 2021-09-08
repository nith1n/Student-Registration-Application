package com.student.registration.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.registration.model.Student;
import com.student.registration.repositories.StudentRepository;
import com.student.registration.services.DataValidationService;
import com.student.registration.services.SequenceGeneratorService;

@RestController
public class StudentController {

	@Autowired
	public StudentRepository studentRepository;

	@Autowired
	private SequenceGeneratorService service;

	@Autowired
	private DataValidationService validation;

	@Autowired
	private MongoOperations mongoOperations;




	// Manage GET Request

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value="/list")
	public List<Student> getStudents() {

		// Sorting Data by Name
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC,"name"));
		return mongoOperations.find(query, Student.class);

	}


	// Manage POST Request

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value="/create")
	public String createStudent(@RequestBody Student student) {	

		// Format Name - Removes Extra White Spaces
		student.setName(student.getName().trim().replaceAll(" +", " "));

		//Format Gender - Capitalizes first character
		String str = student.getGender();
		student.setGender(str.substring(0, 1).toUpperCase() + str.substring(1));

		//Format Date of Birth - merges day, month and year
		student.setDateOfBirth(student.getDobDay()+"/"+student.getDobMonth()+"/"+student.getDobYear());


		//Validate Name	
		String nameError = validation.validateName(student);
		if(nameError!=null) return nameError;

		//Validate Date of Birth		
		String dateError = validation.validateDate(student);
		if(dateError!=null) return dateError;


		//Validate Class
		String classError = validation.validateClass(student);
		if(classError!=null) return classError;

		//Validate Gender
		String genderError = validation.validateGender(student);
		if(genderError!=null) return genderError;


		//Generate Unique Sequence Number
		int seq_id = service.getSequenceNumber(Student.SEQUENCE_NAME);
		student.setId(seq_id);


		// GENERATE ROLL NUMBER

		int temp_id = seq_id;
		int digits = 0;
		while (temp_id != 0) {
			temp_id /= 10;
			++digits;
		}

		switch(digits) {
		case 1 : student.setRollNumber("R-00"+seq_id);break;
		case 2 : student.setRollNumber("R-0"+seq_id);break;
		default: student.setRollNumber("R-"+seq_id);
		}




		// Inserts data into database

		Student insertedStudent = studentRepository.insert(student);
		return " New Student '"+insertedStudent.getName()+"' has been added";



	}

}

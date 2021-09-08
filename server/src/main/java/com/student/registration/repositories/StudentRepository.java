package com.student.registration.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.student.registration.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,Long>{
	
}

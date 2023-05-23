package com.example.stuber.services;

import com.example.stuber.models.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
	List<Student> getstudents();
	ResponseEntity<Object> addstudent(Student student);



	List<Student> getStudentByParentId(long id);
}

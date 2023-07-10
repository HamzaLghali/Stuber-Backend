package com.example.stuber.controllers;

import com.example.stuber.models.Student;
import com.example.stuber.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
@CrossOrigin
public class Studentcontroller {
	@Autowired
	StudentServiceImpl studentService;
	@GetMapping
	List<Student> getallstudents(){
		return studentService.getstudents();
	}
	@PostMapping
	ResponseEntity<Object> addstudent(@RequestBody Student student){
		return studentService.addstudent(student);
	}
	@GetMapping("/Parent/{id}")
	List<Student>getStudentsByParentId(@PathVariable long id){
		return studentService.getStudentByParentId(id);
	}
}

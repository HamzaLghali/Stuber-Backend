package com.example.stuber.controllers;

import com.example.stuber.models.School;
import com.example.stuber.services.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/School")
@CrossOrigin
public class Schoolcontroller {
	@Autowired
	SchoolServiceImpl schoolService;
	@GetMapping
	List<School> getschools(){
		return schoolService.getschools();
	}
	@PostMapping
	ResponseEntity<School> addschool(@RequestBody School school){
		return schoolService.addschool(school);
	}

}

package com.example.stuber.services;

import com.example.stuber.models.School;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SchoolService {
	List<School> getschools();
	ResponseEntity<School> addschool(School school);
}

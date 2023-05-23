package com.example.stuber.services;

import com.example.stuber.models.Adress;
import com.example.stuber.models.School;
import com.example.stuber.repository.Adressrepository;
import com.example.stuber.repository.Schoolrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	Schoolrepository schoolrepository;
	@Autowired
	Adressrepository adressrepository;
	@Override
	public List<School> getschools() {
		return schoolrepository.findAll();
	}

	@Override
	public ResponseEntity<School> addschool(School school) {
		Adress adress = school.getAdress();
		adressrepository.save(adress);
		school.setAdress(adress);
		School savedschool = schoolrepository.save(school);
		return ResponseEntity.ok(savedschool);
	}
}

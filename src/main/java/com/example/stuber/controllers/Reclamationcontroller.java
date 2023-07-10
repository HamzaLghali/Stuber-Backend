package com.example.stuber.controllers;

import com.example.stuber.models.Reclamation;
import com.example.stuber.services.ReclamationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamation")
@CrossOrigin
public class Reclamationcontroller {
	@Autowired
	ReclamationServiceImpl reclamationService;
	@GetMapping
	List<Reclamation> getReclamations(){
		return reclamationService.getReclamations();
	}
	@PostMapping
	ResponseEntity<Object> addReclamation(@RequestBody Reclamation reclamation){
		return reclamationService.addReclamation(reclamation);
	}
}

package com.example.stuber.services;

import com.example.stuber.models.Reclamation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReclamationService {
	List<Reclamation> getReclamations();
	ResponseEntity<Object> addReclamation(Reclamation reclamation);
}

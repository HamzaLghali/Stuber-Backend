package com.example.stuber.services;

import com.example.stuber.models.Parent;
import com.example.stuber.models.Reclamation;
import com.example.stuber.repository.Reclamationrepository;
import com.example.stuber.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationServiceImpl implements ReclamationService{
	@Autowired
	Reclamationrepository reclamationrepository;
	@Autowired
	Userrepository userrepository;
	@Override
	public List<Reclamation> getReclamations() {
		return reclamationrepository.findAll();
	}

	@Override
	public ResponseEntity<Object> addReclamation(Reclamation reclamation) {
		Optional<Parent> optionalParent = userrepository.findParentById((long)reclamation.getParent().getId());
		if (!optionalParent.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Parent parent = optionalParent.get();
		reclamation.setParent(parent);
		Reclamation savedreclamtion = reclamationrepository.save(reclamation);
		return ResponseEntity.ok(savedreclamtion);
	}
}

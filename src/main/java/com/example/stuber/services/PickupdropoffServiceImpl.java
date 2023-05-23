package com.example.stuber.services;

import com.example.stuber.models.Adress;
import com.example.stuber.models.PickupDropoff;
import com.example.stuber.models.Student;
import com.example.stuber.repository.Adressrepository;
import com.example.stuber.repository.Pickupdropoffrepository;
import com.example.stuber.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PickupdropoffServiceImpl implements PickupdropoffService{
	@Autowired
	Pickupdropoffrepository pickupdropoffrepository;
	@Autowired
	Studentrepository studentrepository;
	@Autowired
	Adressrepository adressrepository;
	@Override
	public List<PickupDropoff> getPickupsdropoffsByStudentId(Long id) {
		return pickupdropoffrepository.findPickupDropoffsByStudentId(id);
	}

	@Override
	public List<PickupDropoff> getPickupsdropoffs() {
		return pickupdropoffrepository.findAll();
	}

	@Override
	public ResponseEntity<PickupDropoff> addPickupdropoff(PickupDropoff pickupDropoff) {
		Adress location = pickupDropoff.getLocation();
		adressrepository.save(location);
		pickupDropoff.setLocation(location);

		Optional<Student> optionalStudent = studentrepository.findById((long)pickupDropoff.getStudent().getId());
		if (!optionalStudent.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Student student = optionalStudent.get();
		pickupDropoff.setStudent(student);

		pickupDropoff.setTime(LocalDateTime.now());
		PickupDropoff savedpickdrop = pickupdropoffrepository.save(pickupDropoff);
		return ResponseEntity.ok(savedpickdrop);
	}
}

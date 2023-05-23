package com.example.stuber.services;

import com.example.stuber.models.PickupDropoff;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PickupdropoffService {
	List<PickupDropoff> getPickupsdropoffsByStudentId(Long id);

	List<PickupDropoff> getPickupsdropoffs();

	ResponseEntity<PickupDropoff> addPickupdropoff(PickupDropoff pickupDropoff);
}

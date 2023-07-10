package com.example.stuber.controllers;

import com.example.stuber.models.PickupDropoff;
import com.example.stuber.services.PickupdropoffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pickdrop")
public class Pickupdropoffcontroller {
	@Autowired
	PickupdropoffServiceImpl pickupdropoffService;
	@GetMapping("/{id}")
	List<PickupDropoff> getPickupdropoffByStudentId(@PathVariable Long id){
		return pickupdropoffService.getPickupsdropoffsByStudentId(id);
	}

	@GetMapping
	List<PickupDropoff> getPickupdropoff(){
		return pickupdropoffService.getPickupsdropoffs();
	}
	@PostMapping
	ResponseEntity<PickupDropoff> addPickupdropoff(@RequestBody PickupDropoff pickupDropoff){
		return pickupdropoffService.addPickupdropoff(pickupDropoff);
	}
}

package com.example.stuber.controllers;

import com.example.stuber.models.Itinerary;
import com.example.stuber.services.ItineraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Itinerary")
@CrossOrigin
public class Itinerarycontroller {
	@Autowired
	ItineraryServiceImpl itineraryService;
	@GetMapping
	List<Itinerary> getItineraries(){
		return itineraryService.getitineraries();
	}
	@PostMapping
	ResponseEntity<Object> addItinerary(@RequestBody Itinerary itinerary){
		return itineraryService.additinerary(itinerary);
	}
	@GetMapping("/{id}")
	Optional<Itinerary> getItineraryById(@PathVariable Long id){
		return itineraryService.getItineraryById(id);
	}
	@PostMapping("/updatestatus/{id}")
	void updateItineraryStatus(@PathVariable Long id){
		itineraryService.updateItineraryStatus(id);
	}
	@DeleteMapping("/{id}")
	void deleteItineraryById(@PathVariable Long id){
		itineraryService.deleteById(id);
	}
}

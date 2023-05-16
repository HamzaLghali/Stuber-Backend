package com.example.stuber.services;

import com.example.stuber.models.Itinerary;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ItineraryService {
	List<Itinerary> getitineraries();
	ResponseEntity<Object> additinerary(Itinerary itinerary);
	void deleteById(Long id);
	Optional<Itinerary> getItineraryById(Long id);
	void updateItineraryStatus(Long id);
}

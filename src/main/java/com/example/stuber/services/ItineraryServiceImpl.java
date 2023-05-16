package com.example.stuber.services;

import com.example.stuber.models.*;
import com.example.stuber.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItineraryServiceImpl implements ItineraryService{
	@Autowired
	Itineraryrepository itineraryrepository;
	@Autowired
	Adressrepository adressrepository;
	@Autowired
	Busrepository busrepository;
	@Autowired
	Userrepository userrepository;
	@Autowired
	Studentrepository studentrepository;

	@Override
	public List<Itinerary> getitineraries() {
		return itineraryrepository.findAll();
	}

	@Override
	public ResponseEntity<Object> additinerary(Itinerary itinerary) {
		Adress start = itinerary.getStart();
		Adress end = itinerary.getEnd();
		adressrepository.save(start);
		adressrepository.save(end);

		List<Student> students = new ArrayList<>();
		for (Student student : itinerary.getStudents()) {
			Optional<Student> optionalStudent = studentrepository.findById((long) student.getId());
			if (!optionalStudent.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			students.add(optionalStudent.get());
		}

		Optional<Bus> optionalBus = busrepository.findById((long)itinerary.getBus().getId());
		if (!optionalBus.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Bus bus = optionalBus.get();


		Optional<Driver> optionalDriver = userrepository.findDriverById((long)itinerary.getDriver().getId());
		if (!optionalDriver.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Driver driver = optionalDriver.get();

		itinerary.setStart(start);
		itinerary.setEnd(end);
		itinerary.setStudents(students);
		itinerary.setBus(bus);
		itinerary.setDriver(driver);
		Itinerary savedItinerary = itineraryrepository.save(itinerary);
		return ResponseEntity.ok(savedItinerary);
	}

	@Override
	public void deleteById(Long id) {
		itineraryrepository.deleteById(id);
	}

	public Optional<Itinerary> getItineraryById(Long id) {
		return itineraryrepository.findById(Long.valueOf(id));
	}

	@Override
	public void updateItineraryStatus(Long id) {
		Optional<Itinerary> optionalItinerary = itineraryrepository.findById(id);
		if (!optionalItinerary.isPresent()) {
			ResponseEntity.notFound().build();
		}
		Itinerary itinerary = optionalItinerary.get();
		itinerary.setArrived(true);
		itineraryrepository.save(itinerary);
	}
}

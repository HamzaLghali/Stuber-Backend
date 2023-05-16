package com.example.stuber.controllers;

import com.example.stuber.models.Bus;
import com.example.stuber.services.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Bus")
@CrossOrigin
public class Buscontroller {
	@Autowired
	BusServiceImpl busService;
	@GetMapping
	List<Bus> getbuses(){
		return busService.getbuses();
	}

	@GetMapping("/nbrbuses")
	Long getNumberBuses(){
		return busService.getNumberBuses();
	}
	@PostMapping
	Bus addbus(@RequestBody Bus bus){
		return busService.addbus(bus);
	}
	@DeleteMapping("/{id}")
	void deleteBusById(@PathVariable long id){
		busService.deleteBusById(id);
	}
}

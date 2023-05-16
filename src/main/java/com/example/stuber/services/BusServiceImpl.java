package com.example.stuber.services;

import com.example.stuber.models.Bus;
import com.example.stuber.repository.Busrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusServiceImpl implements BusService{

	@Autowired
	Busrepository busrepository;
	@Override
	public List<Bus> getbuses() {
		return busrepository.findAll();
	}

	@Override
	public Bus addbus(Bus bus) {
		return busrepository.save(bus);
	}

	@Override
	public void deleteBusById(long id) {
		busrepository.deleteById(id);
	}

	@Override
	public Long getNumberBuses() {
		return busrepository.countBuses();
	}
}

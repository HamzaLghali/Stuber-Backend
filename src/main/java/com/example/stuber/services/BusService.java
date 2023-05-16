package com.example.stuber.services;

import com.example.stuber.models.Bus;
import com.example.stuber.models.Driver;
import com.example.stuber.models.Parent;
import com.example.stuber.models.User;

import java.util.List;

public interface BusService {
	List<Bus> getbuses();
	Bus addbus(Bus bus);

	void deleteBusById(long id);

	Long getNumberBuses();

}

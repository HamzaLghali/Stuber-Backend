package com.example.stuber.services;

import com.example.stuber.models.Driver;
import com.example.stuber.models.Parent;
import com.example.stuber.models.User;

import java.util.List;

public interface UserService {
	List<User>getusers();
	List<Driver> getdrivers();
	List<Parent> getparents();
	User adduser(User user);
	Driver adddriver(Driver driver);
	Parent addparent(Parent parent);
	void deleteUserById(Long id);

	Long getNumberOfDrivers();



}

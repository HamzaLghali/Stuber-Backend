package com.example.stuber.services;

import com.example.stuber.models.Driver;
import com.example.stuber.models.Parent;
import com.example.stuber.models.User;
import com.example.stuber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userrepository;
	@Override
	public List<User> getusers() {
		return userrepository.findAll();
	}

	@Override
	public List<Driver> getdrivers() {
		return userrepository.getdrivers();
	}

	@Override
	public List<Parent> getparents() {
		return userrepository.getparents();
	}

	@Override
	public User adduser(User user) {
		return userrepository.save(user);
	}

	@Override
	public Driver adddriver(Driver driver) {
		return userrepository.save(driver);
	}

	@Override
	public Parent addparent(Parent parent) {
		return userrepository.save(parent);
	}

	@Override
	public void deleteUserById(Long id) {
		userrepository.deleteById(id);
	}

	@Override
	public Long getNumberOfDrivers() {
		return userrepository.countDrivers();
	}


}

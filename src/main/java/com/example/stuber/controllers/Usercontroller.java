package com.example.stuber.controllers;

import com.example.stuber.models.Adress;
import com.example.stuber.models.Driver;
import com.example.stuber.models.Parent;
import com.example.stuber.models.User;
import com.example.stuber.repository.Adressrepository;
import com.example.stuber.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
@CrossOrigin
public class Usercontroller {
	@Autowired
	UserServiceImpl userService;
	@Autowired
	Adressrepository adressrepository;
	@GetMapping
	List<User> getusers(){
		return userService.getusers();
	}
	@PostMapping
	User adduser(@RequestBody User user){
		return userService.adduser(user);
	}
	@GetMapping("/Driver")
	List<Driver>getdrivers(){
		return userService.getdrivers();
	}

	@PostMapping("/Driver")
	User adduser(@RequestBody Driver driver){
		return userService.adduser(driver);
	}

	@GetMapping("/Driver/nbrdrivers")
	Long getNumberOfDrivers(){
		return userService.getNumberOfDrivers();
	}

	@GetMapping("/Parent")
	List<Parent>getparents(){
		return userService.getparents();
	}

	@PostMapping("/Parent")
	Parent adduser(@RequestBody Parent parent){
		Adress adress = parent.getAdress();
		adressrepository.save(adress);
		parent.setAdress(adress);
		return userService.addparent(parent);
	}
	@DeleteMapping("/{id}")
	void deleteUserById(@PathVariable long id){
		userService.deleteUserById(id);
	}

}

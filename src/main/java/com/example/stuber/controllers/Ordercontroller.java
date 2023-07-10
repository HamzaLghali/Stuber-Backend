package com.example.stuber.controllers;

import com.example.stuber.models.Order;
import com.example.stuber.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Order")
@CrossOrigin
public class Ordercontroller {
	@Autowired
	OrderServiceImpl orderService;
	@GetMapping
	List<Order> getOrders(){
		return orderService.getOrders();
	}
	@PostMapping
	ResponseEntity<Object> addOrder(@RequestBody Order order){
		return orderService.addOrder(order);
	}

	@GetMapping("/Parent/{id}")
	List<Order> getOrdersByParentId(@PathVariable long id){
		return orderService.getOrdersByParentId(id);
	}
}

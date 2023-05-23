package com.example.stuber.services;

import com.example.stuber.models.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
	List<Order> getOrders();
	ResponseEntity<Object> addOrder(Order order);
	List<Order> getOrdersByParentId(long id);

}

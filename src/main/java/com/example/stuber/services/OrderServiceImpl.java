package com.example.stuber.services;

import com.example.stuber.models.*;
import com.example.stuber.repository.Adressrepository;
import com.example.stuber.repository.Orderrepository;
import com.example.stuber.repository.Studentrepository;
import com.example.stuber.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	Orderrepository orderrepository;
	@Autowired
	Userrepository userrepository;
	@Autowired
	Studentrepository studentrepository;
	@Autowired
	Adressrepository adressrepository;
	@Override
	public List<Order> getOrders() {
		return orderrepository.findAll();
	}

	@Override
	public ResponseEntity<Object> addOrder(Order order) {
		Adress start = order.getStart();

		adressrepository.save(start);

		Optional<Parent> optionalParent = userrepository.findParentById((long)order.getParent().getId());
		if (!optionalParent.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Parent parent = optionalParent.get();

		Optional<Student> optionalBus = studentrepository.findById((long)order.getStudent().getId());
		if (!optionalBus.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Student student = optionalBus.get();
		order.setParent(parent);
		order.setStudent(student);
		order.setStart(start);

		Order savedorder = orderrepository.save(order);
		return ResponseEntity.ok(savedorder);
	}

	@Override
	public List<Order> getOrdersByParentId(long id) {
		return orderrepository.findOrderByParentId(id);
	}
}

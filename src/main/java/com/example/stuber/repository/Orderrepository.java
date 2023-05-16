package com.example.stuber.repository;

import com.example.stuber.models.Order;
import com.example.stuber.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Orderrepository extends JpaRepository<Order,Long> {
	@Query("SELECT o FROM Order o WHERE o.parent.id = :id")
	List<Order> findOrderByParentId(@Param("id") Long id);

	@Query("SELECT COUNT(o) FROM Order o")
	Long countOrders();
}

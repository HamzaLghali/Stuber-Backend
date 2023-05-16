package com.example.stuber.repository;

import com.example.stuber.models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Busrepository extends JpaRepository<Bus,Long> {

	@Query("SELECT COUNT(b) FROM Bus b")
	Long countBuses();
}

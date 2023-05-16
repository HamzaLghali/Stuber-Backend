package com.example.stuber.repository;

import com.example.stuber.models.PickupDropoff;
import com.example.stuber.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Pickupdropoffrepository extends JpaRepository<PickupDropoff,Long> {
	@Query("SELECT p FROM PickupDropoff p WHERE p.student.id = :id")
	List<PickupDropoff> findPickupDropoffsByStudentId(@Param("id") Long id);
}

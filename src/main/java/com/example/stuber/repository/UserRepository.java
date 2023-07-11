package com.example.stuber.repository;

import com.example.stuber.models.Driver;
import com.example.stuber.models.Parent;
import com.example.stuber.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByUsername(String username);

	@Query("select driver from Driver driver")
	List<Driver> getdrivers();
	@Query("select parent from Parent parent")
	List<Parent>getparents();
	@Query("SELECT COUNT(d) FROM Driver d")
	Long countDrivers();

	@Query("select schoolowner from Schoolowner schoolowner")
	List<Parent>getschoolowners();
	@Query("SELECT p FROM Parent p WHERE p.id = :id")
	Optional<Parent> findParentById(@Param("id") Long id);
	@Query("SELECT d FROM Driver d WHERE d.id = :id")
	Optional<Driver> findDriverById(@Param("id") Long id);
}

package com.example.stuber.repository;

import com.example.stuber.models.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Itineraryrepository extends JpaRepository<Itinerary,Long> {

}

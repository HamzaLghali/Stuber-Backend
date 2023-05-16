package com.example.stuber.repository;

import com.example.stuber.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Schoolrepository extends JpaRepository<School,Long> {
}

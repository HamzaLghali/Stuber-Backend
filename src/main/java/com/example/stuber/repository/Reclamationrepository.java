package com.example.stuber.repository;

import com.example.stuber.models.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reclamationrepository extends JpaRepository<Reclamation,Long> {
}

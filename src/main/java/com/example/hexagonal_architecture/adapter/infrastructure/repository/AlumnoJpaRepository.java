package com.example.hexagonal_architecture.adapter.infrastructure.repository;

import com.example.hexagonal_architecture.adapter.infrastructure.model.AlumnoJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoJpaRepository extends JpaRepository<AlumnoJpa, Long> {
}

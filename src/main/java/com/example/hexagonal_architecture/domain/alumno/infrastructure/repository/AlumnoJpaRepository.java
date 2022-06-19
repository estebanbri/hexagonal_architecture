package com.example.hexagonal_architecture.domain.alumno.infrastructure.repository;

import com.example.hexagonal_architecture.domain.alumno.infrastructure.model.AlumnoJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoJpaRepository extends JpaRepository<AlumnoJpa, Long> {
}

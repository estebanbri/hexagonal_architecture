package com.example.hexagonal_architecture.persistence_jpa.repository;

import com.example.hexagonal_architecture.persistence_jpa.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}

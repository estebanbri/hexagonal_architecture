package com.example.hexagonal_architecture.domain.port.in;

import com.example.hexagonal_architecture.domain.model.Alumno;

import java.util.List;

public interface FindAlumnoAllINPort {
    List<Alumno> findAllAlumnos();
}

package com.example.hexagonal_architecture.domain.alumno.core.port.in;

import com.example.hexagonal_architecture.domain.alumno.core.model.Alumno;

import java.util.List;

public interface FindAlumnoAllINPort {
    List<Alumno> findAllAlumnos();
}

package com.example.hexagonal_architecture.domain.alumno.core.port.out;

import com.example.hexagonal_architecture.domain.alumno.core.model.Alumno;

import java.util.List;

public interface FindAlumnoAllOUTPort {
    List<Alumno> findAllAlumnos();
}

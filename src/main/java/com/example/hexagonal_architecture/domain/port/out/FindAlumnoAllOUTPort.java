package com.example.hexagonal_architecture.domain.port.out;

import com.example.hexagonal_architecture.domain.model.Alumno;

import java.util.List;

public interface FindAlumnoAllOUTPort {
    List<Alumno> findAllAlumnos();
}

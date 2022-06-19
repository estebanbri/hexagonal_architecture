package com.example.hexagonal_architecture.domain.port.in;

import com.example.hexagonal_architecture.domain.model.Alumno;

public interface FindAlumnoByIdINPort {
    Alumno findAlumnoById(Long id);
}

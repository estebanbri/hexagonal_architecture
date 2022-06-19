package com.example.hexagonal_architecture.domain.alumno.core.port.in;

import com.example.hexagonal_architecture.domain.alumno.core.model.Alumno;

public interface FindAlumnoByIdINPort {
    Alumno findAlumnoById(Long id);
}

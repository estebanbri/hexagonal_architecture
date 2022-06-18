package com.example.hexagonal_architecture.application.port.incoming;

import com.example.hexagonal_architecture.application.domain.Alumno;

public interface FindAlumnoINPort {
    Alumno findAlumnoById(Long id);
}

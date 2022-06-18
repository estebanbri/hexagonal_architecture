package com.example.hexagonal_architecture.application.port.outcomming;

import com.example.hexagonal_architecture.application.domain.Alumno;

public interface FindAlumnoOUTPort {
    Alumno findAlumnoById(Long id);
}

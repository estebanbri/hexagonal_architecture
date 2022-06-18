package com.example.hexagonal_architecture.application.port.incoming;

import com.example.hexagonal_architecture.application.domain.Alumno;

public interface SaveAlumnoINPort {
    Alumno saveAlumno(Alumno alumno);
}

package com.example.hexagonal_architecture.domain.port.out;

import com.example.hexagonal_architecture.domain.model.Alumno;

public interface SaveAlumnoOUTPort {
    Alumno saveAlumno(Alumno alumno);
}

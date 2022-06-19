package com.example.hexagonal_architecture.domain.alumno.core.port.out;

import com.example.hexagonal_architecture.domain.alumno.core.model.Alumno;

public interface SaveAlumnoOUTPort {
    Alumno saveAlumno(Alumno alumno);
}

package com.example.hexagonal_architecture.domain.alumno.core.usecase;

import com.example.hexagonal_architecture.domain.alumno.core.model.Alumno;
import com.example.hexagonal_architecture.domain.alumno.core.port.in.SaveAlumnoINPort;
import com.example.hexagonal_architecture.domain.alumno.core.port.out.SaveAlumnoOUTPort;

public class SaveAlumnoUseCase implements SaveAlumnoINPort {

    private final SaveAlumnoOUTPort saveAlumnoOUTPort;

    public SaveAlumnoUseCase(SaveAlumnoOUTPort saveAlumnoOUTPort) {
        this.saveAlumnoOUTPort = saveAlumnoOUTPort;
    }

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return saveAlumnoOUTPort.saveAlumno(alumno);
    }
}

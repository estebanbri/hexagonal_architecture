package com.example.hexagonal_architecture.domain.usecase;

import com.example.hexagonal_architecture.domain.model.Alumno;
import com.example.hexagonal_architecture.domain.port.in.SaveAlumnoINPort;
import com.example.hexagonal_architecture.domain.port.out.SaveAlumnoOUTPort;

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

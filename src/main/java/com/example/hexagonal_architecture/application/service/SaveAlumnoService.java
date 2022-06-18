package com.example.hexagonal_architecture.application.service;

import com.example.hexagonal_architecture.application.domain.Alumno;
import com.example.hexagonal_architecture.application.port.incoming.SaveAlumnoINPort;
import com.example.hexagonal_architecture.application.port.outcomming.SaveAlumnoOUTPort;

public class SaveAlumnoService implements SaveAlumnoINPort {

    private final SaveAlumnoOUTPort saveAlumnoOUTPort;

    public SaveAlumnoService(SaveAlumnoOUTPort saveAlumnoOUTPort) {
        this.saveAlumnoOUTPort = saveAlumnoOUTPort;
    }

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return saveAlumnoOUTPort.saveAlumno(alumno);
    }
}

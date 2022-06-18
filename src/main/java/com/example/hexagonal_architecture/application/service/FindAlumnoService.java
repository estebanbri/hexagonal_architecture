package com.example.hexagonal_architecture.application.service;

import com.example.hexagonal_architecture.application.domain.Alumno;
import com.example.hexagonal_architecture.application.port.incoming.FindAlumnoINPort;
import com.example.hexagonal_architecture.application.port.outcomming.FindAlumnoOUTPort;

public class FindAlumnoService implements FindAlumnoINPort {

    private final FindAlumnoOUTPort findAlumnoOUTPort;

    public FindAlumnoService(FindAlumnoOUTPort findAlumnoOUTPort) {
        this.findAlumnoOUTPort = findAlumnoOUTPort;
    }

    @Override
    public Alumno findAlumnoById(Long id) {
        return findAlumnoOUTPort.findAlumnoById(id);
    }
}

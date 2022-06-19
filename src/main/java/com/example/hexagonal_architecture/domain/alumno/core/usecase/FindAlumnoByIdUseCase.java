package com.example.hexagonal_architecture.domain.alumno.core.usecase;

import com.example.hexagonal_architecture.domain.alumno.core.port.out.FindAlumnoByIdOUTPort;
import com.example.hexagonal_architecture.domain.alumno.core.model.Alumno;
import com.example.hexagonal_architecture.domain.alumno.core.port.in.FindAlumnoByIdINPort;

public class FindAlumnoByIdUseCase implements FindAlumnoByIdINPort {

    private final FindAlumnoByIdOUTPort findAlumnoByIdOUTPort;

    public FindAlumnoByIdUseCase(FindAlumnoByIdOUTPort findAlumnoByIdOUTPort) {
        this.findAlumnoByIdOUTPort = findAlumnoByIdOUTPort;
    }

    @Override
    public Alumno findAlumnoById(Long id) {
        return findAlumnoByIdOUTPort.findAlumnoById(id);
    }
}

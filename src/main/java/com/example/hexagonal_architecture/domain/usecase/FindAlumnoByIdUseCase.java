package com.example.hexagonal_architecture.domain.usecase;

import com.example.hexagonal_architecture.domain.model.Alumno;
import com.example.hexagonal_architecture.domain.port.in.FindAlumnoByIdINPort;
import com.example.hexagonal_architecture.domain.port.out.FindAlumnoByIdOUTPort;

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

package com.example.hexagonal_architecture.domain.usecase;

import com.example.hexagonal_architecture.domain.model.Alumno;
import com.example.hexagonal_architecture.domain.port.in.FindAlumnoAllINPort;
import com.example.hexagonal_architecture.domain.port.out.FindAlumnoAllOUTPort;

import java.util.List;

public class FindAllAlumnoUseCase implements FindAlumnoAllINPort {

    private final FindAlumnoAllOUTPort findAlumnoAllOUTPort;

    public FindAllAlumnoUseCase(FindAlumnoAllOUTPort findAlumnoAllOUTPort) {
        this.findAlumnoAllOUTPort = findAlumnoAllOUTPort;
    }

    @Override
    public List<Alumno> findAllAlumnos() {
        return findAlumnoAllOUTPort.findAllAlumnos();
    }
}

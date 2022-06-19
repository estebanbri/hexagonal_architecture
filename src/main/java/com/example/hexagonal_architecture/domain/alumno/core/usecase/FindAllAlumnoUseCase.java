package com.example.hexagonal_architecture.domain.alumno.core.usecase;

import com.example.hexagonal_architecture.domain.alumno.core.model.Alumno;
import com.example.hexagonal_architecture.domain.alumno.core.port.in.FindAlumnoAllINPort;
import com.example.hexagonal_architecture.domain.alumno.core.port.out.FindAlumnoAllOUTPort;

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

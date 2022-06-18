package com.example.hexagonal_architecture.adapters.persistence;

import com.example.hexagonal_architecture.application.domain.Alumno;
import com.example.hexagonal_architecture.application.port.outcomming.FindAlumnoOUTPort;
import com.example.hexagonal_architecture.application.port.outcomming.SaveAlumnoOUTPort;
import org.springframework.stereotype.Component;

@Component
public class AlumnoRepository implements SaveAlumnoOUTPort, FindAlumnoOUTPort {

    private final AlumnoJPARepository alumnoJPARepository;

    public AlumnoRepository(AlumnoJPARepository alumnoJPARepository) {
        this.alumnoJPARepository = alumnoJPARepository;
    }

    @Override
    public Alumno findAlumnoById(Long id) {
        return alumnoJPARepository.findAlumnoById();
    }

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return alumnoJPARepository.saveAlumno(alumno);
    }
}

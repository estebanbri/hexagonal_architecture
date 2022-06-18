package com.example.hexagonal_architecture.adapters.rest;

import com.example.hexagonal_architecture.application.domain.Alumno;
import com.example.hexagonal_architecture.application.port.incoming.FindAlumnoINPort;
import com.example.hexagonal_architecture.application.port.incoming.SaveAlumnoINPort;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoController {

    private final FindAlumnoINPort findAlumnoINPort;
    private final SaveAlumnoINPort saveAlumnoINPort;

    public AlumnoController(FindAlumnoINPort findAlumnoINPort,
                            SaveAlumnoINPort saveAlumnoINPort) {
        this.findAlumnoINPort = findAlumnoINPort;
        this.saveAlumnoINPort = saveAlumnoINPort;
    }

    public Alumno findAlumnoById(Long id) {
        return findAlumnoINPort.findAlumnoById(id);
    }

    public Alumno saveAlumno(Alumno alumno) {
        return saveAlumnoINPort.saveAlumno(alumno);
    }

}

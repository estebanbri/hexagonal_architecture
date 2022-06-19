package com.example.hexagonal_architecture.adapter.rest;

import com.example.hexagonal_architecture.domain.model.Alumno;
import com.example.hexagonal_architecture.domain.port.in.FindAlumnoAllINPort;
import com.example.hexagonal_architecture.domain.port.in.FindAlumnoByIdINPort;
import com.example.hexagonal_architecture.domain.port.in.SaveAlumnoINPort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/alumnos")
public class AlumnoRestAdapter {

    private final FindAlumnoAllINPort findAllAlumnosPort;
    private final FindAlumnoByIdINPort findAlumnoByIdPort;
    private final SaveAlumnoINPort saveAlumnoPort;

    public AlumnoRestAdapter(FindAlumnoAllINPort findAllAlumnosPort,
                             FindAlumnoByIdINPort findAlumnoByIdPort,
                             SaveAlumnoINPort saveAlumnoPort) {
        this.findAllAlumnosPort = findAllAlumnosPort;
        this.findAlumnoByIdPort = findAlumnoByIdPort;
        this.saveAlumnoPort = saveAlumnoPort;
    }

    @GetMapping
    public List<Alumno> findAllAlumnos() {
        return this.findAllAlumnosPort.findAllAlumnos();
    }

    @GetMapping("/{id}")
    public Alumno findAlumnoById(Long id) {
        return this.findAlumnoByIdPort.findAlumnoById(id);
    }

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return this.saveAlumnoPort.saveAlumno(alumno);
    }
}

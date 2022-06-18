package com.example.hexagonal_architecture.rest.adapter;

import com.example.hexagonal_architecture.core.service.AlumnoService;
import com.example.hexagonal_architecture.domain.data.AlumnoDTO;
import com.example.hexagonal_architecture.domain.port.inbound.AlumnoControllerPort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/alumnos")
public class AlumnoRestAdapter implements AlumnoControllerPort {

    private final AlumnoService alumnoService;

    public AlumnoRestAdapter(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @Override
    @GetMapping
    public List<AlumnoDTO> findAllAlumnos() {
        return alumnoService.findAllAlumnos();
    }

    @Override
    @GetMapping("/{id}")
    public AlumnoDTO findAlumnoById(Long id) {
        return alumnoService.findAlumnoById(id);
    }

    @Override
    @PostMapping
    public AlumnoDTO createAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        return alumnoService.createAlumno(alumnoDTO);
    }
}

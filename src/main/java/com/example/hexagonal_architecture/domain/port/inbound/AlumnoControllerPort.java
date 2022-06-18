package com.example.hexagonal_architecture.domain.port.inbound;

import com.example.hexagonal_architecture.domain.data.AlumnoDTO;

import java.util.List;

public interface AlumnoControllerPort {
    List<AlumnoDTO> findAllAlumnos();
    AlumnoDTO findAlumnoById(Long id);
    AlumnoDTO createAlumno(AlumnoDTO alumnoDTO);
}

package com.example.hexagonal_architecture.domain.port.outbound;

import com.example.hexagonal_architecture.domain.data.AlumnoDTO;

import java.util.List;

public interface AlumnoPersistencePort {
    List<AlumnoDTO> findAllAlumnos();
    AlumnoDTO findAlumnoById(Long id);
    AlumnoDTO createAlumno(AlumnoDTO alumnoDTO);
}

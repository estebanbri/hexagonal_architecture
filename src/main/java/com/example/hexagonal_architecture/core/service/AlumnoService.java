package com.example.hexagonal_architecture.core.service;

import com.example.hexagonal_architecture.domain.data.AlumnoDTO;

import java.util.List;

public interface AlumnoService {
    List<AlumnoDTO> findAllAlumnos();
    AlumnoDTO findAlumnoById(Long id);
    AlumnoDTO createAlumno(AlumnoDTO alumnoDTO);
}

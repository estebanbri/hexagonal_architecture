package com.example.hexagonal_architecture.core.service;

import com.example.hexagonal_architecture.domain.data.AlumnoDTO;
import com.example.hexagonal_architecture.domain.port.outbound.AlumnoPersistencePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoPersistencePort alumnoPersistencePort;

    public AlumnoServiceImpl(AlumnoPersistencePort alumnoPersistencePort) {
        this.alumnoPersistencePort = alumnoPersistencePort;
    }

    @Override
    public List<AlumnoDTO> findAllAlumnos() {
        return alumnoPersistencePort.findAllAlumnos();
    }

    @Override
    public AlumnoDTO findAlumnoById(Long id) {
        return alumnoPersistencePort.findAlumnoById(id);
    }

    @Override
    public AlumnoDTO createAlumno(AlumnoDTO alumnoDTO) {
        return alumnoPersistencePort.createAlumno(alumnoDTO);
    }
}

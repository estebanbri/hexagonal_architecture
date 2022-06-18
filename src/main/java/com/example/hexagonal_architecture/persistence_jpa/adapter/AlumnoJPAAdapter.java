package com.example.hexagonal_architecture.persistence_jpa.adapter;

import com.example.hexagonal_architecture.domain.data.AlumnoDTO;
import com.example.hexagonal_architecture.domain.exception.AlumnoNotFoundException;
import com.example.hexagonal_architecture.domain.port.outbound.AlumnoPersistencePort;
import com.example.hexagonal_architecture.persistence_jpa.model.Alumno;
import com.example.hexagonal_architecture.persistence_jpa.repository.AlumnoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoJPAAdapter implements AlumnoPersistencePort {

    private final AlumnoRepository alumnoRepository;

    public AlumnoJPAAdapter(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public List<AlumnoDTO> findAllAlumnos() {
        return alumnoRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AlumnoDTO findAlumnoById(Long id) {
        return alumnoRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(AlumnoNotFoundException::new);
    }

    @Override
    public AlumnoDTO createAlumno(AlumnoDTO alumnoDTO) {
        return toDto(alumnoRepository.save(toEntity(alumnoDTO)));
    }

    private Alumno toEntity(AlumnoDTO alumnoDTO) {
        Alumno alumno = new Alumno();
        BeanUtils.copyProperties(alumnoDTO, alumno);
        return alumno;
    }

    private AlumnoDTO toDto(Alumno alumno) {
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        BeanUtils.copyProperties(alumno, alumnoDTO);
        return alumnoDTO;
    }
}

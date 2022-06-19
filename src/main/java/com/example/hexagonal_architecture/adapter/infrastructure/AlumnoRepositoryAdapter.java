package com.example.hexagonal_architecture.adapter.infrastructure;

import com.example.hexagonal_architecture.adapter.infrastructure.mapper.AlumnoMapper;
import com.example.hexagonal_architecture.adapter.infrastructure.model.AlumnoJpa;
import com.example.hexagonal_architecture.adapter.infrastructure.repository.AlumnoJpaRepository;
import com.example.hexagonal_architecture.domain.exception.AlumnoNotFoundException;
import com.example.hexagonal_architecture.domain.model.Alumno;
import com.example.hexagonal_architecture.domain.port.out.FindAlumnoAllOUTPort;
import com.example.hexagonal_architecture.domain.port.out.FindAlumnoByIdOUTPort;
import com.example.hexagonal_architecture.domain.port.out.SaveAlumnoOUTPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AlumnoRepositoryAdapter
        implements FindAlumnoAllOUTPort, FindAlumnoByIdOUTPort, SaveAlumnoOUTPort {

    private final AlumnoJpaRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;

    public AlumnoRepositoryAdapter(AlumnoJpaRepository alumnoJpaRepository,
                                   AlumnoMapper alumnoMapper) {
        this.alumnoRepository = alumnoJpaRepository;
        this.alumnoMapper = alumnoMapper;
    }

    @Override
    public List<Alumno> findAllAlumnos() {
        return this.alumnoRepository.findAll().stream()
                .map(this::toAlumno)
                .collect(Collectors.toList());
    }

    @Override
    public Alumno findAlumnoById(Long id) {
        return alumnoRepository.findById(id)
                .map(this::toAlumno)
                .orElseThrow(AlumnoNotFoundException::new);
    }

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return toAlumno(alumnoRepository.save(toAlumnoJpa(alumno)));
    }

    private AlumnoJpa toAlumnoJpa(Alumno alumno) {
        return this.alumnoMapper.toAlumnoJpa(alumno);
    }

    private Alumno toAlumno(AlumnoJpa alumnoJpa) {
        return this.alumnoMapper.toAlumno(alumnoJpa);
    }

}

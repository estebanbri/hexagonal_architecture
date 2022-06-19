package com.example.hexagonal_architecture.domain.alumno.infrastructure;

import com.example.hexagonal_architecture.domain.alumno.infrastructure.mapper.AlumnoMapper;
import com.example.hexagonal_architecture.domain.alumno.infrastructure.model.AlumnoJpa;
import com.example.hexagonal_architecture.domain.alumno.infrastructure.repository.AlumnoJpaRepository;
import com.example.hexagonal_architecture.domain.alumno.core.model.Alumno;
import com.example.hexagonal_architecture.domain.alumno.core.port.out.FindAlumnoAllOUTPort;
import com.example.hexagonal_architecture.domain.alumno.core.port.out.FindAlumnoByIdOUTPort;
import com.example.hexagonal_architecture.domain.alumno.core.port.out.SaveAlumnoOUTPort;
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
                .orElseThrow(RuntimeException::new);
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

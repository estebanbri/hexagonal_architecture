package com.example.hexagonal_architecture.adapter.infrastructure.mapper;

import com.example.hexagonal_architecture.domain.model.Alumno;
import com.example.hexagonal_architecture.adapter.infrastructure.model.AlumnoJpa;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AlumnoMapper {

    public AlumnoJpa toAlumnoJpa(Alumno alumno) {
        AlumnoJpa alumnoJpa = new AlumnoJpa();
        BeanUtils.copyProperties(alumno, alumnoJpa);
        return alumnoJpa;
    }

    public Alumno toAlumno(AlumnoJpa alumnoJpa) {
        Alumno alumno = new Alumno();
        BeanUtils.copyProperties(alumnoJpa, alumno);
        return alumno;
    }

}

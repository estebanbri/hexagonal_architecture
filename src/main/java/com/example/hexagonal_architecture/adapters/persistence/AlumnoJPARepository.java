package com.example.hexagonal_architecture.adapters.persistence;

import com.example.hexagonal_architecture.application.domain.Alumno;

public interface AlumnoJPARepository
       // extends JPARepository
{
    Alumno findAlumnoById();

    Alumno saveAlumno(Alumno alumno);
}

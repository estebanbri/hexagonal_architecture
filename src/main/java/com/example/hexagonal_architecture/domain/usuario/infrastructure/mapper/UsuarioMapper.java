package com.example.hexagonal_architecture.domain.usuario.infrastructure.mapper;

import com.example.hexagonal_architecture.domain.usuario.core.model.Usuario;
import com.example.hexagonal_architecture.domain.usuario.infrastructure.model.UsuarioJpa;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioJpa toAlumnoJpa(Usuario alumno) {
        UsuarioJpa usuarioJpa = new UsuarioJpa();
        BeanUtils.copyProperties(alumno, usuarioJpa);
        return usuarioJpa;
    }

    public Usuario toAlumno(UsuarioJpa usuarioJpa) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioJpa, usuario);
        return usuario;
    }

}

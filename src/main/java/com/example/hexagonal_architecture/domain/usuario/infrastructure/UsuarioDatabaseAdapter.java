package com.example.hexagonal_architecture.domain.usuario.infrastructure;

import com.example.hexagonal_architecture.domain.usuario.core.port.out.UsuarioDatabase;
import com.example.hexagonal_architecture.domain.usuario.infrastructure.mapper.UsuarioMapper;
import com.example.hexagonal_architecture.domain.usuario.infrastructure.model.UsuarioJpa;
import com.example.hexagonal_architecture.domain.usuario.infrastructure.repository.UsuarioJpaRepository;
import com.example.hexagonal_architecture.domain.usuario.core.model.Usuario;
import org.springframework.stereotype.Repository;


@Repository
public class UsuarioDatabaseAdapter  // adaptador de salida
        implements UsuarioDatabase { // implementa puerto de salida

    private final UsuarioJpaRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioDatabaseAdapter(UsuarioJpaRepository usuarioRepository,
                                  UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return toUsuario(usuarioRepository.save(toUsuarioJpa(usuario)));
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .map(this::toUsuario)
                .orElse(null);
    }

    private UsuarioJpa toUsuarioJpa(Usuario alumno) {
        return this.usuarioMapper.toAlumnoJpa(alumno);
    }

    private Usuario toUsuario(UsuarioJpa usuarioJpa) {
        return this.usuarioMapper.toAlumno(usuarioJpa);
    }



}

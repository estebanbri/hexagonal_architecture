package com.example.hexagonal_architecture.domain.usuario.core.port.out;

import com.example.hexagonal_architecture.domain.usuario.core.model.Usuario;

public interface UsuarioDatabase {
    Long save(Usuario usuario);
    Usuario findById(Long id);
}

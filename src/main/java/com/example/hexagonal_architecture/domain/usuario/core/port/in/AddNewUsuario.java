package com.example.hexagonal_architecture.domain.usuario.core.port.in;

import com.example.hexagonal_architecture.domain.usuario.core.model.Usuario;

public interface AddNewUsuario {
    Long handle(Usuario usuario);
}

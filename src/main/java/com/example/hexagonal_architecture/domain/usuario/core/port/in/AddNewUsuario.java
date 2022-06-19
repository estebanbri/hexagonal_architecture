package com.example.hexagonal_architecture.domain.usuario.core.port.in;

import com.example.hexagonal_architecture.domain.usuario.core.model.Usuario;

public interface AddNewUsuario {
    Usuario handle(Usuario usuario);
}

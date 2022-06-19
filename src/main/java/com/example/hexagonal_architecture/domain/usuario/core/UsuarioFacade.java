package com.example.hexagonal_architecture.domain.usuario.core;

import com.example.hexagonal_architecture.domain.usuario.core.model.Usuario;
import com.example.hexagonal_architecture.domain.usuario.core.port.in.AddNewUsuario;
import com.example.hexagonal_architecture.domain.usuario.core.port.out.UsuarioDatabase;

public class UsuarioFacade // adapter del puerto de entrada
        implements AddNewUsuario { // implementa puerto de entrada

    private final UsuarioDatabase usuarioDatabase; // usa puerto de salida

    public UsuarioFacade(UsuarioDatabase usuarioDatabase) {
        this.usuarioDatabase = usuarioDatabase;
    }

    @Override
    public Usuario handle(Usuario usuario) {
        return usuarioDatabase.save(usuario);
    }

}

package com.example.hexagonal_architecture.domain.usuario.application;

import com.example.hexagonal_architecture.domain.usuario.application.model.AddUsuarioRequest;
import com.example.hexagonal_architecture.domain.usuario.core.model.Usuario;
import com.example.hexagonal_architecture.domain.usuario.core.port.in.AddNewUsuario;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final AddNewUsuario addNewUsuario; // usa puerto de entrada

    public UsuarioController(AddNewUsuario addNewUsuario) {
        this.addNewUsuario = addNewUsuario;
    }

    @PostMapping
    public Long addNewUser(@RequestBody AddUsuarioRequest usuarioRequest) {
        Usuario user = new Usuario();
        BeanUtils.copyProperties(usuarioRequest, user);
        return this.addNewUsuario.handle(user);
    }

}

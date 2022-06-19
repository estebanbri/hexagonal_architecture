package com.example.hexagonal_architecture.infrastructure;

import com.example.hexagonal_architecture.domain.usuario.core.UsuarioFacade;
import com.example.hexagonal_architecture.domain.usuario.core.port.in.AddNewUsuario;
import com.example.hexagonal_architecture.domain.usuario.core.port.out.UsuarioDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Se llama AlumnoCoreConfig porque fijate que necesita el domain.core unicamente especificarle explicitamente aqui los @Bean
// porque en el domain.core no puede haber ninguna anotacion de framework alguno, por teniendo en cuenta unicamente tenes
// que registrar los usercase que definiste dentro de la carpeta core.
@Configuration
public class UsuarioCoreConfig {

    @Bean
    public AddNewUsuario addNewUsuario(UsuarioDatabase usuarioDatabase) {
        return new UsuarioFacade(usuarioDatabase);
    }

}

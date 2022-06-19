package com.example.hexagonal_architecture.config;

import com.example.hexagonal_architecture.domain.port.in.FindAlumnoAllINPort;
import com.example.hexagonal_architecture.domain.port.in.FindAlumnoByIdINPort;
import com.example.hexagonal_architecture.domain.port.in.SaveAlumnoINPort;
import com.example.hexagonal_architecture.domain.port.out.FindAlumnoAllOUTPort;
import com.example.hexagonal_architecture.domain.port.out.FindAlumnoByIdOUTPort;
import com.example.hexagonal_architecture.domain.port.out.SaveAlumnoOUTPort;
import com.example.hexagonal_architecture.domain.usecase.FindAllAlumnoUseCase;
import com.example.hexagonal_architecture.domain.usecase.FindAlumnoByIdUseCase;
import com.example.hexagonal_architecture.domain.usecase.SaveAlumnoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Se llama CoreInjection porque fijate que necesita el core unicamente especificarle explicitamente aqui los @Bean
// porque en el core no puede haber ninguna anotacion de framework alguno, por teniendo en cuenta unicamente tenes
// que registrar los usercase que definiste dentro de la carpeta core.
@Configuration
public class CoreInjection {

    @Bean
    public FindAlumnoAllINPort findAlumnoAllINPort(FindAlumnoAllOUTPort findAlumnoAllOUTPort) {
        return new FindAllAlumnoUseCase(findAlumnoAllOUTPort);
    }

    @Bean
    public FindAlumnoByIdINPort findAlumnoByIdINPort(FindAlumnoByIdOUTPort findAlumnoByIdOUTPort) {
        return new FindAlumnoByIdUseCase(findAlumnoByIdOUTPort);
    }

    @Bean
    public SaveAlumnoINPort saveAlumnoINPort(SaveAlumnoOUTPort saveAlumnoOUTPort) {
        return new SaveAlumnoUseCase(saveAlumnoOUTPort);
    }

}

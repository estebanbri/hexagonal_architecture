package com.example.hexagonal_architecture.infrastructure;

import com.example.hexagonal_architecture.domain.alumno.core.port.in.FindAlumnoAllINPort;
import com.example.hexagonal_architecture.domain.alumno.core.port.in.FindAlumnoByIdINPort;
import com.example.hexagonal_architecture.domain.alumno.core.port.in.SaveAlumnoINPort;
import com.example.hexagonal_architecture.domain.alumno.core.port.out.FindAlumnoAllOUTPort;
import com.example.hexagonal_architecture.domain.alumno.core.port.out.FindAlumnoByIdOUTPort;
import com.example.hexagonal_architecture.domain.alumno.core.port.out.SaveAlumnoOUTPort;
import com.example.hexagonal_architecture.domain.alumno.core.usecase.FindAllAlumnoUseCase;
import com.example.hexagonal_architecture.domain.alumno.core.usecase.FindAlumnoByIdUseCase;
import com.example.hexagonal_architecture.domain.alumno.core.usecase.SaveAlumnoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Se llama AlumnoDomainCoreConfig porque fijate que necesita el domain.core unicamente especificarle explicitamente aqui los @Bean
// porque en el domain.core no puede haber ninguna anotacion de framework alguno, por teniendo en cuenta unicamente tenes
// que registrar los usercase que definiste dentro de la carpeta core.
@Configuration
public class AlumnoDomainCoreConfig {

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

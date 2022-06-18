package com.example.hexagonal_architecture.adapters.configuration;

import com.example.hexagonal_architecture.adapters.persistence.AlumnoRepository;
import com.example.hexagonal_architecture.adapters.rest.AlumnoController;
import com.example.hexagonal_architecture.application.port.incoming.FindAlumnoINPort;
import com.example.hexagonal_architecture.application.port.incoming.SaveAlumnoINPort;
import com.example.hexagonal_architecture.application.service.FindAlumnoService;
import com.example.hexagonal_architecture.application.service.SaveAlumnoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final AlumnoRepository alumnoRepository;

    public BeanConfiguration(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Bean
    public SaveAlumnoINPort saveAlumnoINPort() {
        return new SaveAlumnoService(alumnoRepository);
    }

    @Bean
    public FindAlumnoINPort findAlumnoINPort() {
        return new FindAlumnoService(alumnoRepository);
    }

    @Bean
    public AlumnoController alumnoController() {
        return new AlumnoController(findAlumnoINPort(), saveAlumnoINPort());
    }


}

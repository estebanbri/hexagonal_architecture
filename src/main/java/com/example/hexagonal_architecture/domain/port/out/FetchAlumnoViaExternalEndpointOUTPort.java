package com.example.hexagonal_architecture.domain.port.out;

// Interface a modo de ejemplo, solo para demostrar que puede tener varias puertos y no necesariamente
// cada adapter tenga que implementarlos todos si o si, por ejemplo el adapter de jpa no necesita implementarlo porque
// este puerto es para traer via http externo el alumno.
public interface FetchAlumnoViaExternalEndpointOUTPort {
}

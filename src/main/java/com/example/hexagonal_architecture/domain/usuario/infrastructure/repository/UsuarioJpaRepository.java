package com.example.hexagonal_architecture.domain.usuario.infrastructure.repository;

import com.example.hexagonal_architecture.domain.usuario.infrastructure.model.UsuarioJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioJpa, Long> {
}

package com.orcamento.cerca.repository;

import com.orcamento.cerca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioReposiroty extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}

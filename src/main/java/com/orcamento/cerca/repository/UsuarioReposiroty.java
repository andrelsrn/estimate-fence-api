package com.orcamento.cerca.repository;

import com.orcamento.cerca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioReposiroty extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}

package com.orcamento.cerca.service;

import com.orcamento.cerca.repository.UsuarioReposiroty;
import com.orcamento.cerca.model.Usuario;
import com.orcamento.cerca.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioReposiroty usuarioRepository;
    private final JwtUtil jwtUtil;

    public UsuarioService(UsuarioReposiroty usuarioReposiroty, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioReposiroty;
        this.jwtUtil = jwtUtil;
    }

    public String autenticar(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getPassword().equals(password)) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtUtil.generateToken(username);
    }
}
package com.orcamento.cerca.service;

import com.orcamento.cerca.repository.UsuarioReposiroty;
import com.orcamento.cerca.model.Usuario;
import com.orcamento.cerca.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final JwtUtil jwtUtil;
    private final UsuarioReposiroty usuarioReposiroty;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioReposiroty usuarioReposiroty, BCryptPasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
        this.usuarioReposiroty = usuarioReposiroty;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario salvar(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioReposiroty.save(usuario);
    }

    public String autenticar(String username, String password) {
        Usuario usuario = usuarioReposiroty.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtUtil.generateToken(username);
    }
}
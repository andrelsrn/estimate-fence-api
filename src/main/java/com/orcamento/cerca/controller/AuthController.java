package com.orcamento.cerca.controller;

import com.orcamento.cerca.DTO.LoginRequestDTO;
import com.orcamento.cerca.DTO.RegisterRequest;
import com.orcamento.cerca.model.Usuario;
import com.orcamento.cerca.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

    @RestController
    @RequestMapping("/auth")
    public class AuthController {


        private final UsuarioService usuarioService;

        public AuthController(UsuarioService usuarioService) {
            this.usuarioService = usuarioService;
        }

        @PostMapping("/login")
        public Map<String, String> login(@RequestBody LoginRequestDTO loginData) {
            String token = usuarioService.autenticar(
                    loginData.username(),
                    loginData.password()
            );

            return Map.of("token", token);
        }

        @PostMapping("/register")
        public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
            Usuario usuario = usuarioService.salvar(request);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

    }


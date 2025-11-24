package com.orcamento.cerca.controller;

import com.orcamento.cerca.service.UsuarioService;
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
        public Map<String, String> login(@RequestBody Map<String, String> loginData) {
            String username = loginData.get("username");
            String password = loginData.get("password");

            String token = usuarioService.autenticar(username, password);

            return Map.of("token", token);
        }
    }


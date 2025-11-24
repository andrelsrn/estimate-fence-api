package com.orcamento.cerca.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestSenhaHash {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senha = "1234"; // senha que você quer
        String hash = encoder.encode(senha);
        System.out.println(hash);
    }
}

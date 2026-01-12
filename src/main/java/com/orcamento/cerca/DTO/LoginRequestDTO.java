package com.orcamento.cerca.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequestDTO (
    @Schema(description = "Nome de usuário para login", example = "usuario123")
    String username,

    @Schema(description = "Senha do usuário para login", example = "senhaSegura!")
    String password
) {
    public LoginRequestDTO {
        username = username != null ? username.trim() : null;
        password = password != null ? password.trim() : null;
    }
}


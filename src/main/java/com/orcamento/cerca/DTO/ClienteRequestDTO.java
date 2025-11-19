package com.orcamento.cerca.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public record ClienteRequestDTO(
        @Schema(description = "Nome completo do cliente", example = "João da Silva")
        String nome,

        @Schema(description = "E-mail do cliente", example = "joao@gmail.com")
        String email
) {

    public ClienteRequestDTO {
        nome = nome != null ? nome.trim() : null;
        email = email != null ? email.trim() : null;
}
}

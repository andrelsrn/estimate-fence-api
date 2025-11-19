package com.orcamento.cerca.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public record ClienteResponseDTO(

        @Schema(description = "ID único do cliente", example = "1")
        Long id,

        @Schema(description = "Nome completo do cliente", example = "João da Silva")
        String nome,

        @Schema(description = "E-mail do cliente", example = "joao@gmail.com")
        String email
) {}
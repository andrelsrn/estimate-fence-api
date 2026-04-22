package com.orcamento.cerca.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public record ClienteRequestDTO(
        @Schema(description = "Nome completo do cliente", example = "João da Silva")
        String nome,

        @Schema(description = "E-mail do cliente", example = "joao@gmail.com")
        String email,

        @Schema(description = "Telefone do cliente", example = "(234) 352-4155")
        String telefone,

        @Schema(description = "Endereço do cliente", example = "35 Proctor St, Salem - MA, 01970")
        String endereco
) {

    public ClienteRequestDTO {
        nome = nome != null ? nome.trim() : null;
        email = email != null ? email.trim() : null;
        telefone = telefone != null ? telefone.trim() : null;
        endereco = endereco != null ? endereco.trim() : null;
}
}

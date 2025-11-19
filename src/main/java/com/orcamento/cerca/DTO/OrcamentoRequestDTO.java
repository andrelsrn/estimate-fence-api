package com.orcamento.cerca.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "Dados de entrada para criação de um orçamento")
public record OrcamentoRequestDTO(

        @Schema(description = "Nome do cliente", example = "João Silva")
        String clienteNome,

        @Schema(description = "E-mail do cliente", example = "joao@email.com")
        String clienteEmail,

        @Schema(description = "Lista de itens do orçamento")
        List<ItemRequestDTO> itens
) {}

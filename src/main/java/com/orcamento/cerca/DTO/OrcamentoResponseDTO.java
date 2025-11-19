package com.orcamento.cerca.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import com.orcamento.cerca.model.Orcamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Resposta completa de um orçamento")
public record OrcamentoResponseDTO(

        @Schema(description = "ID do orçamento", example = "1")
        Long id,

        @Schema(description = "Valor total do orçamento", example = "1500.00")
        BigDecimal valorTotal,

        @Schema(description = "Data de criação do orçamento")
        LocalDateTime dataCadastro,

        @Schema(description = "Dados do cliente")
        ClienteResponseDTO cliente,

        @Schema(description = "Itens do orçamento")
        List<ItemResponseDTO> itens
) {

    public OrcamentoResponseDTO(Orcamento o) {
        this(
                o.getId(),
                o.getValorTotal(),
                o.getDataCadastro(),
                new ClienteResponseDTO(o.getCliente()),
                o.getItens().stream()
                        .map(ItemResponseDTO::new)
                        .toList()
        );
    }
}

package com.orcamento.cerca.DTO;

import com.orcamento.cerca.model.Orcamento;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Resumo de orçamento usado em listagens")
public record OrcamentoSummaryDTO(

        @Schema(description = "ID do orçamento", example = "15")
        Long id,

        @Schema(description = "Nome do cliente", example = "João Silva")
        String cliente,

        @Schema(description = "Valor total do orçamento", example = "1250.50")
        BigDecimal valorTotal,

        @Schema(description = "Data de criação", example = "2025-02-18T10:30:00")
        LocalDateTime dataCadastro,

        @Schema(description = "Quantidade total de itens", example = "3")
        Integer quantidadeItens
) {

    public OrcamentoSummaryDTO(Orcamento o) {
        this(
                o.getId(),
                o.getCliente().getNome(),
                o.getValorTotal(),
                o.getDataCadastro(),
                o.getItens().size()
        );
    }
}

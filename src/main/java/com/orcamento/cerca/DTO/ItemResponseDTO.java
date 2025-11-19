package com.orcamento.cerca.DTO;

import com.orcamento.cerca.model.ItemOrcamento;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Item retornado pelo orçamento")
public record ItemResponseDTO(

        Long id,
        String tamanhoPainel,
        String cor,
        String materialEscolhido,
        BigDecimal totalLinear,
        Boolean portaoIncluso,
        Integer portaoQuantidade,
        BigDecimal valorTotal
) {

    public ItemResponseDTO(ItemOrcamento item) {
        this(
                item.getId(),
                item.getTamanhoPainel(),
                item.getCor(),
                item.getMaterialEscolhido(),
                item.getTotalLinear(),
                item.getPortaoIncluso(),
                item.getPortaoQuantidade(),
                item.getValorTotal()
        );
    }
}

package com.orcamento.cerca.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Item individual do orçamento")
public record ItemRequestDTO(

        @Schema(description = "Tamanho do painel", example = "2m")
        String tamanhoPainel,

        @Schema(description = "Cor do painel", example = "branco")
        String cor,

        @Schema(description = "Material escolhido", example = "aluminio")
        String materialEscolhido,

        @Schema(description = "Total em metros lineares", example = "10.5")
        Double totalLinear,

        @Schema(description = "Define se o item inclui portão", example = "true")
        Boolean portaoIncluso,

        @Schema(description = "Quantidade de portões", example = "1")
        Integer portaoQuantidade
) {
    public ItemRequestDTO {
        tamanhoPainel = tamanhoPainel != null ? tamanhoPainel.trim() : null;
        cor = cor != null ? cor.trim() : null;
        materialEscolhido = materialEscolhido != null ? materialEscolhido.trim() : null;
    }
}

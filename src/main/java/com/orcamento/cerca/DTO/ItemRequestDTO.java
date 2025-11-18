package com.orcamento.cerca.DTO;

public record ItemRequestDTO(
        String tamanhoPainel,
        String cor,
        String materialEscolhido,
        double totalLinear,
        Boolean portaoIncluso,
        Integer portaoQuantidade
) {}

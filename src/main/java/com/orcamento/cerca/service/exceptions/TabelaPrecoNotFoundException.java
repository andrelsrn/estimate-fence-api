package com.orcamento.cerca.service.exceptions;

public class TabelaPrecoNotFoundException extends RuntimeException {
    public TabelaPrecoNotFoundException(String tamanho, String cor, String material) {
        super("Tabela de preço não encontrada para tamanho: " + tamanho +
                ", cor: " + cor +
                ", material: " + material);
    }
}
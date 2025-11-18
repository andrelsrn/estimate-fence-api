package com.orcamento.cerca.DTO;


import java.util.List;

public record OrcamentoRequestDTO(
        String clienteNome,
        String clienteEmail,
        List<ItemRequestDTO> itens
) {}

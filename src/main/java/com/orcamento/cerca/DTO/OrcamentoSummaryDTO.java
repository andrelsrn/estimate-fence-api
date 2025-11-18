package com.orcamento.cerca.DTO;

import com.orcamento.cerca.model.Orcamento;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrcamentoSummaryDTO {

    private Long id;
    private BigDecimal valorTotal;
    private LocalDateTime dataCadastro;
    private Long clienteId;
    private String clienteNome;


    public OrcamentoSummaryDTO(Orcamento entity) {
        this.id = entity.getId();
        this.valorTotal = entity.getValorTotal();
        this.dataCadastro = entity.getDataCadastro();


        if (entity.getCliente() != null) {
            this.clienteId = entity.getCliente().getId();
            this.clienteNome = entity.getCliente().getNome();
        }
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public String getClienteNome() {
        return clienteNome;
    }
}
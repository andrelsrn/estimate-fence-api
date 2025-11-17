package com.orcamento.cerca.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Orcamento implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalLinear;
    private double tamanho_painel;
    private String cor;
    private String materialEscolhido;
    private Boolean portaoIncluso;
    private int portaoQuantidade;

    @ManyToOne
    private Cliente cliente;

    private BigDecimal valorTotal;

    private LocalDateTime dataCadastro = LocalDateTime.now();

    public Orcamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalLinear() {
        return totalLinear;
    }

    public void setTotalLinear(double totalLinear) {
        this.totalLinear = totalLinear;
    }

    public double getTamanho_painel() {
        return tamanho_painel;
    }

    public void setTamanho_painel(double tamanho_painel) {
        this.tamanho_painel = tamanho_painel;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMaterialEscolhido() {
        return materialEscolhido;
    }

    public void setMaterialEscolhido(String materialEscolhido) {
        this.materialEscolhido = materialEscolhido;
    }

    public Boolean getPortaoIncluso() {
        return portaoIncluso;
    }

    public void setPortaoIncluso(Boolean portaoIncluso) {
        this.portaoIncluso = portaoIncluso;
    }

    public int getPortaoQuantidade() {
        return portaoQuantidade;
    }

    public void setPortaoQuantidade(int portaoQuantidade) {
        this.portaoQuantidade = portaoQuantidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}

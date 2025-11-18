package com.orcamento.cerca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class ItemOrcamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tamanhoPainel;
    private String cor;
    private String materialEscolhido;
    private BigDecimal totalLinear;
    private Boolean portaoIncluso;
    private Integer portaoQuantidade;
    private BigDecimal valorTotal;

    private BigDecimal precoPorMetroLinear;

    public ItemOrcamento() {
    }

    public ItemOrcamento(Long id, String tamanhoPainel, String cor, String materialEscolhido, BigDecimal totalLinear, Boolean portaoIncluso, Integer portaoQuantidade, BigDecimal valorTotal) {
        this.id = id;
        this.tamanhoPainel = tamanhoPainel;
        this.cor = cor;
        this.materialEscolhido = materialEscolhido;
        this.totalLinear = totalLinear;
        this.portaoIncluso = portaoIncluso;
        this.portaoQuantidade = portaoQuantidade;
        this.valorTotal = valorTotal;
    }

    public BigDecimal calcularValorTotal(BigDecimal precoPorMetroLinear) {
        BigDecimal valorCalculado = precoPorMetroLinear.multiply(this.totalLinear);
        this.valorTotal = valorCalculado;
        return valorCalculado;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }


    public String getTamanhoPainel() {
        return tamanhoPainel;
    }

    public void setTamanhoPainel(String tamanhoPainel) {
        this.tamanhoPainel = tamanhoPainel;
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

    public BigDecimal getTotalLinear() {
        return totalLinear;
    }

    public void setTotalLinear(BigDecimal totalLinear) {
        this.totalLinear = totalLinear;
    }

    public Boolean getPortaoIncluso() {
        return portaoIncluso;
    }

    public void setPortaoIncluso(Boolean portaoIncluso) {
        this.portaoIncluso = portaoIncluso;
    }

    public Integer getPortaoQuantidade() {
        return portaoQuantidade;
    }

    public void setPortaoQuantidade(Integer portaoQuantidade) {
        this.portaoQuantidade = portaoQuantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemOrcamento that = (ItemOrcamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

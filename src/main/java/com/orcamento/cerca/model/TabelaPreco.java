package com.orcamento.cerca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class TabelaPreco implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tamanhoPainel;
    private String cor;
    private String material;


    private BigDecimal precoPorMetroLinear;

    public TabelaPreco() {
    }

    public TabelaPreco(Long id, String tamanhoPainel, String cor, String material, BigDecimal precoPorMetroLinear) {
        this.id = id;
        this.tamanhoPainel = tamanhoPainel;
        this.cor = cor;
        this.material = material;
        this.precoPorMetroLinear = precoPorMetroLinear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public BigDecimal getPrecoPorMetroLinear() {
        return precoPorMetroLinear;
    }

    public void setPrecoPorMetroLinear(BigDecimal precoPorMetroLinear) {
        this.precoPorMetroLinear = precoPorMetroLinear;
    }
}

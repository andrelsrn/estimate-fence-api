package com.orcamento.cerca.repository;

import com.orcamento.cerca.model.TabelaPreco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TabelaPrecoRepository extends JpaRepository<TabelaPreco, Long> {

    Optional<TabelaPreco> findByPainelCorMaterial(String tamanhoPainel, String cor, String material);

}

package com.orcamento.cerca.controller;

import com.orcamento.cerca.DTO.OrcamentoRequestDTO;
import com.orcamento.cerca.model.Orcamento;
import com.orcamento.cerca.service.OrcamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estimates" )
public class OrcamentoController {

    private final OrcamentoService orcamentoService;

    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @PostMapping
    public ResponseEntity<Orcamento> criarOrcamento(@RequestBody OrcamentoRequestDTO dto) {
        Orcamento orcamento = orcamentoService.calcularESalvar(dto);
        return ResponseEntity.status(201).body(orcamento);
    }

    @GetMapping("/{id}" )
    public ResponseEntity<Orcamento> buscarPorId(@PathVariable Long id) {
        Orcamento orcamento = orcamentoService.buscarPorId(id);
        return ResponseEntity.ok(orcamento);
    }



}

package com.orcamento.cerca.controller;

import com.orcamento.cerca.DTO.OrcamentoRequestDTO;
import com.orcamento.cerca.DTO.OrcamentoSummaryDTO;
import com.orcamento.cerca.model.Orcamento;
import com.orcamento.cerca.service.OrcamentoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

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


    private static final int MAX_LIMIT = 50;

    @GetMapping
    public ResponseEntity<List<OrcamentoSummaryDTO>> findAll(
            @RequestParam(defaultValue = "20") int limit) {


        int effectiveLimit = Math.min(limit, MAX_LIMIT);

        List<OrcamentoSummaryDTO> list = orcamentoService.findWithLimit(effectiveLimit);

        return ResponseEntity.ok(list);
    }




}

package com.orcamento.cerca.controller;

import com.orcamento.cerca.DTO.OrcamentoRequestDTO;
import com.orcamento.cerca.DTO.OrcamentoResponseDTO;
import com.orcamento.cerca.DTO.OrcamentoSummaryDTO;
import com.orcamento.cerca.service.OrcamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orcamentos")
@Tag(name = "Orçamentos", description = "Gerenciamento de orçamentos e cálculo total")
public class OrcamentoController {

    private final OrcamentoService orcamentoService;

    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @Operation(
            summary = "Criar novo orçamento",
            description = "Calcula automaticamente o valor total do orçamento e salva no banco."
    )
    @PostMapping
    public ResponseEntity<OrcamentoResponseDTO> criar(@RequestBody OrcamentoRequestDTO dto) {
        OrcamentoResponseDTO created = orcamentoService.calcularESalvar(dto);
        URI uri = URI.create("/orcamentos/" + created.id());
        return ResponseEntity.created(uri).body(created);
    }

    @Operation(
            summary = "Buscar orçamento por ID",
            description = "Retorna um orçamento completo usando seu identificador."
    )
    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(orcamentoService.buscarPorId(id));
    }

    @Operation(
            summary = "Listar orçamentos",
            description = "Retorna todos os orçamentos ou uma quantidade limitada usando o parâmetro `limit`."
    )
    @GetMapping
    public ResponseEntity<List<OrcamentoSummaryDTO>> listarTodos(@RequestParam(name = "limit", required = false) Integer limit) {
        if (limit != null) {
            return ResponseEntity.ok(orcamentoService.findWithLimit(limit));
        }
        return ResponseEntity.ok(orcamentoService.listarTodos());
    }

    @Operation(
            summary = "Excluir orçamento",
            description = "Remove um orçamento definitivamente do sistema."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        orcamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

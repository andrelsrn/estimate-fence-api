package com.orcamento.cerca.service;

import com.orcamento.cerca.DTO.ItemRequestDTO;
import com.orcamento.cerca.DTO.OrcamentoRequestDTO;
import com.orcamento.cerca.DTO.OrcamentoResponseDTO;
import com.orcamento.cerca.DTO.OrcamentoSummaryDTO;
import com.orcamento.cerca.model.Cliente;
import com.orcamento.cerca.model.ItemOrcamento;
import com.orcamento.cerca.model.Orcamento;
import com.orcamento.cerca.repository.OrcamentoRepository;
import com.orcamento.cerca.repository.TabelaPrecoRepository;
import com.orcamento.cerca.service.exceptions.TabelaPrecoNotFoundException;
import com.orcamento.cerca.service.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;
    private final TabelaPrecoRepository tabelaPrecoRepository;
    private final ClienteService clienteService;

    public OrcamentoService(OrcamentoRepository orcamentoRepository,
                            TabelaPrecoRepository tabelaPrecoRepository,
                            ClienteService clienteService) {
        this.orcamentoRepository = orcamentoRepository;
        this.tabelaPrecoRepository = tabelaPrecoRepository;
        this.clienteService = clienteService;
    }

    /**
     * Calcula os itens, cria cliente quando necessário e salva o orçamento.
     */
    @Transactional
    public OrcamentoResponseDTO calcularESalvar(OrcamentoRequestDTO dto) {

        Cliente cliente = clienteService.buscarOuCriar(dto.clienteNome(), dto.clienteEmail());

        Orcamento orcamento = new Orcamento();
        orcamento.setCliente(cliente);
        orcamento.setDataCadastro(LocalDateTime.now());

        BigDecimal totalGeral = BigDecimal.ZERO;

        for (ItemRequestDTO itemDto : dto.itens()) {

            String cor = itemDto.cor().trim().toLowerCase();
            String material = itemDto.materialEscolhido().trim().toLowerCase();
            String tamanho = itemDto.tamanhoPainel().trim().toLowerCase();

            var tabelaPreco = tabelaPrecoRepository.findByTamanhoPainelAndCorAndMaterial(
                            tamanho, cor, material)
                    .orElseThrow(() -> new TabelaPrecoNotFoundException(tamanho, cor, material));

            BigDecimal comprimento = BigDecimal.valueOf(itemDto.totalLinear());

            ItemOrcamento item = new ItemOrcamento();
            item.setTamanhoPainel(itemDto.tamanhoPainel());
            item.setCor(itemDto.cor());
            item.setMaterialEscolhido(itemDto.materialEscolhido());
            item.setTotalLinear(comprimento);
            item.setPortaoIncluso(itemDto.portaoIncluso());
            item.setPortaoQuantidade(itemDto.portaoQuantidade());

            BigDecimal valorItem = item.calcularValorTotal(tabelaPreco.getPrecoPorMetroLinear());

            orcamento.addItem(item);
            totalGeral = totalGeral.add(valorItem);
        }

        orcamento.setValorTotal(totalGeral);

        orcamento = orcamentoRepository.save(orcamento);

        return new OrcamentoResponseDTO(orcamento);
    }

    public OrcamentoResponseDTO buscarPorId(Long id) {
        Orcamento o = orcamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orçamento não encontrado. Id: " + id));
        return new OrcamentoResponseDTO(o);
    }

    public List<OrcamentoSummaryDTO> findWithLimit(int limit) {
        PageRequest pageRequest = PageRequest.of(0, limit, Sort.by("dataCadastro").descending());
        List<Orcamento> list = orcamentoRepository.findAll(pageRequest).getContent();
        return list.stream().map(OrcamentoSummaryDTO::new).collect(Collectors.toList());
    }

    public List<OrcamentoSummaryDTO> listarTodos() {
        return orcamentoRepository.findAll(Sort.by("dataCadastro").descending())
                .stream().map(OrcamentoSummaryDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public void deletar(Long id) {
        if (!orcamentoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Orçamento não encontrado. Id: " + id);
        }
        orcamentoRepository.deleteById(id);
    }
}

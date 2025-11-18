package com.orcamento.cerca.service;

import com.orcamento.cerca.DTO.ItemRequestDTO;
import com.orcamento.cerca.DTO.OrcamentoRequestDTO;
import com.orcamento.cerca.model.Cliente;
import com.orcamento.cerca.model.ItemOrcamento;
import com.orcamento.cerca.model.Orcamento;
import com.orcamento.cerca.repository.ClienteRepository;
import com.orcamento.cerca.repository.OrcamentoRepository;
import com.orcamento.cerca.repository.TabelaPrecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;
    private final TabelaPrecoRepository tabelaPrecoRepository;
    private final ClienteService clienteService;


    public OrcamentoService(OrcamentoRepository orcamentoRepository, TabelaPrecoRepository tabelaPrecoRepository, ClienteService clienteService) {
        this.orcamentoRepository = orcamentoRepository;
        this.tabelaPrecoRepository = tabelaPrecoRepository;
        this.clienteService = clienteService;
    }

    @Transactional
    public Orcamento calcularESalvar(OrcamentoRequestDTO dto){


        Cliente cliente = clienteService.buscarOuCriar(dto.clienteNome(), dto.clienteEmail());


        Orcamento orcamento = new Orcamento();
        orcamento.setCliente(cliente);
        orcamento.setDataCadastro(LocalDateTime.now());

        BigDecimal totalGeral = BigDecimal.ZERO;


        for (ItemRequestDTO itemDto : dto.itens()) {


            var tabelaPreco = tabelaPrecoRepository.findByTamanhoPainelAfterAndCorAndMaterial(
                    itemDto.tamanhoPainel(),
                    itemDto.cor(),
                    itemDto.materialEscolhido()
            ).orElseThrow(() -> new RuntimeException("Tabela de Preço não encontrada para um dos itens fornecidos."));


            var comprimento = BigDecimal.valueOf(itemDto.totalLinear());


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

        return orcamentoRepository.save(orcamento);
    }
}

package com.orcamento.cerca.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orcamento.cerca.DTO.ItemRequestDTO;
import com.orcamento.cerca.DTO.OrcamentoRequestDTO;
import com.orcamento.cerca.model.Cliente;
import com.orcamento.cerca.model.Orcamento;
import com.orcamento.cerca.repository.ClienteRepository;
import com.orcamento.cerca.repository.OrcamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrcamentoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    private static final String ENDPOINT = "/estimates";

    private Long idExistente;

    @BeforeEach
    void setUp() {
        orcamentoRepository.deleteAll();
        clienteRepository.deleteAll();

        Cliente cliente = new Cliente(null, "Cliente Teste GET", "teste.get@api.com");
        Cliente clienteSalvo = clienteRepository.save(cliente);

        Orcamento orcamento = new Orcamento();
        orcamento.setCliente(clienteSalvo);
        orcamento.setDataCadastro(LocalDateTime.now());
        orcamento.setValorTotal(new BigDecimal("100.00"));

        Orcamento orcamentoSalvo = orcamentoRepository.save(orcamento);
        this.idExistente = orcamentoSalvo.getId();
    }


    @Test
    void deveCriarOrcamentoComMultiplosItensERetornar201() throws Exception {

        ItemRequestDTO item1 = new ItemRequestDTO(
                "6x6", "branco", "pvc", 10.0, false, 0
        );
        ItemRequestDTO item2 = new ItemRequestDTO(
                "6x6", "preto", "aluminio", 5.0, true, 1
        );

        OrcamentoRequestDTO requestDTO = new OrcamentoRequestDTO(
                "Cliente POST",
                "cliente.post@api.com",
                List.of(item1, item2)
        );

        String jsonPayload = objectMapper.writeValueAsString(requestDTO);

        mockMvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))

                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cliente.email").value("cliente.post@api.com"))
                .andExpect(jsonPath("$.itens.length()").value(2));
    }

    @Test
    void deveRetornarOrcamentoExistenteComStatus200() throws Exception {
        Long id = this.idExistente;

        mockMvc.perform(get(ENDPOINT + "/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valorTotal").value("100.0"));
    }


}
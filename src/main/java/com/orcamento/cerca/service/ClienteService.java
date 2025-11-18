package com.orcamento.cerca.service;

import com.orcamento.cerca.model.Cliente;
import com.orcamento.cerca.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ClienteService implements Serializable {
    public static final long serialVersionUID = 1L;

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente buscarOuCriar(String nome, String email) {
        return clienteRepository.findByEmail(email)
                .orElseGet(() -> {
                    var novoCliente = new Cliente();
                    novoCliente.setNome(nome);
                    novoCliente.setEmail(email);
                    return clienteRepository.save(novoCliente);
                });
    }
}

package com.orcamento.cerca.service;

import com.orcamento.cerca.DTO.ClienteRequestDTO;
import com.orcamento.cerca.DTO.ClienteResponseDTO;
import com.orcamento.cerca.model.Cliente;
import com.orcamento.cerca.repository.ClienteRepository;
import com.orcamento.cerca.service.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente buscarOuCriar(String nome, String email) {
        return clienteRepository.findByEmail(email)
                .orElseGet(() -> clienteRepository.save(new Cliente(null, nome, email)));
    }


    @Transactional
    public ClienteResponseDTO criar(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente(null, dto.nome(), dto.email());
        clienteRepository.save(cliente);
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }

    public List<ClienteResponseDTO> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(c -> new ClienteResponseDTO(c.getId(), c.getNome(), c.getEmail()))
                .toList();
    }

    @Transactional
    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());

        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }


    @Transactional
    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        clienteRepository.deleteById(id);
    }
}
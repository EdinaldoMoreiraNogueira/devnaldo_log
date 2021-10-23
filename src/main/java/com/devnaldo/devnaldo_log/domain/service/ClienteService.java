package com.devnaldo.devnaldo_log.domain.service;

import com.devnaldo.devnaldo_log.domain.exception.NegocioException;
import com.devnaldo.devnaldo_log.domain.model.Cliente;
import com.devnaldo.devnaldo_log.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteId){
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente salvar(Cliente cliente){
     boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
             .stream()
             .anyMatch(clienteExistente -> clienteExistente.equals(cliente));

     if (emailEmUso){
         throw new NegocioException("Já existe cliente cadastrado com este e-mail");
     }

        return clienteRepository.save(cliente);

    }
    public void deletar(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}

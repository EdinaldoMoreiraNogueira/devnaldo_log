package com.devnaldo.devnaldo_log.domain.service;

import com.devnaldo.devnaldo_log.domain.exception.EntidadeNaoEncontradaException;
import com.devnaldo.devnaldo_log.domain.model.Entrega;
import com.devnaldo.devnaldo_log.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId){

      return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));


    }
}

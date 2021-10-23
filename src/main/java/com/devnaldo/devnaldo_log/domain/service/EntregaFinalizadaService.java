package com.devnaldo.devnaldo_log.domain.service;

import com.devnaldo.devnaldo_log.domain.model.Entrega;
import com.devnaldo.devnaldo_log.domain.model.StatusEntrega;
import com.devnaldo.devnaldo_log.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class EntregaFinalizadaService {

    private EntregaRepository entregaRepository;
    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public void finalizar(Long entregaId){

        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();
        entregaRepository.save(entrega);


    }
}

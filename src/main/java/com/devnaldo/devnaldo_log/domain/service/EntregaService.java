package com.devnaldo.devnaldo_log.domain.service;

import com.devnaldo.devnaldo_log.domain.model.Cliente;
import com.devnaldo.devnaldo_log.domain.model.Entrega;
import com.devnaldo.devnaldo_log.domain.model.StatusEntrega;
import com.devnaldo.devnaldo_log.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class EntregaService {

    private ClienteService clienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){

     Cliente cliente = clienteService.buscar(entrega.getCliente().getId());

        entrega.setStatusEntrega(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }
}

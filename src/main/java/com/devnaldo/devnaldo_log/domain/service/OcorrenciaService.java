package com.devnaldo.devnaldo_log.domain.service;

import com.devnaldo.devnaldo_log.domain.exception.NegocioException;
import com.devnaldo.devnaldo_log.domain.model.Entrega;
import com.devnaldo.devnaldo_log.domain.model.Ocorrencia;
import com.devnaldo.devnaldo_log.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OcorrenciaService {

    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){

        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return entrega.adcionarOcorrencia(descricao);

    }
}

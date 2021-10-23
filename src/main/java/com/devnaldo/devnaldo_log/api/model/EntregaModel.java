package com.devnaldo.devnaldo_log.api.model;


import com.devnaldo.devnaldo_log.domain.model.StatusEntrega;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class EntregaModel {

    private String id;
    private String nomeCliente;
    private ResumoClienteModel resumoClienteModel;
    private DestinatarioModel destinatario;
    private StatusEntrega statusEntrega;
    private BigDecimal taxa;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizada;

}

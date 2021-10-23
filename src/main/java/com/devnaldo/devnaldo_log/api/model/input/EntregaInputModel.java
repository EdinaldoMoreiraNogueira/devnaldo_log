package com.devnaldo.devnaldo_log.api.model.input;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
public class EntregaInputModel {

    @Valid
    @NotNull
    private ClienteIdInput clienteIdInput;

    @Valid
    @NotNull
    private DestinatarioInput destinatarioInput;

    @NotNull
    private BigDecimal taxa;



}

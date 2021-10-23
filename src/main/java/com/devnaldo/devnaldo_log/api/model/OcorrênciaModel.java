package com.devnaldo.devnaldo_log.api.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class OcorrênciaModel {

    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;

}

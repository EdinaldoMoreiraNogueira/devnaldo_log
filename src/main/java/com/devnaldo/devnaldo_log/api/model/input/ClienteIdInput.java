package com.devnaldo.devnaldo_log.api.model.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClienteIdInput {

    @NotNull
    private Long id;
}

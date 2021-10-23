package com.devnaldo.devnaldo_log.api.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Erro {

    private Integer status;
    private OffsetDateTime dateTime;
    private String titulo;
    private List<Campo> campos;

    @Data
    @AllArgsConstructor
    public static class Campo{
        private String nome;
        private String mensagem;
    }

}

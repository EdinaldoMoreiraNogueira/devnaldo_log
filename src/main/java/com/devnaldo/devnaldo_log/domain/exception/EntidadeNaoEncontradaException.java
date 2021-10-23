package com.devnaldo.devnaldo_log.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException{

    private static final long serialVersionUID = 1L;
    public EntidadeNaoEncontradaException(String menssage) {
        super(menssage);
    }
}

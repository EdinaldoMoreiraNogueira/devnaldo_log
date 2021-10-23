package com.devnaldo.devnaldo_log.api.exceptionHandler;

import com.devnaldo.devnaldo_log.domain.exception.EntidadeNaoEncontradaException;
import com.devnaldo.devnaldo_log.domain.exception.NegocioException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandle  extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    protected ResponseEntity<Object> handleMethodArgumentsNotValid(MethodArgumentNotValidException ex,
    HttpHeaders headers, HttpStatus status, WebRequest request){
        List<Erro.Campo> campos = new ArrayList<>();

        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            campos.add(new Erro.Campo("nome", "mensagem"));
        }

        Erro erro = new Erro();
        erro.setStatus(status.value());
        erro.setDateTime(OffsetDateTime.now());
        erro.setTitulo("Campo invalido, preencha corretamente");
        erro.setCampos(campos);
        return handleExceptionInternal(ex, erro, headers, status, request);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontraa(EntidadeNaoEncontradaException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        Erro erro = new Erro();
        erro.setStatus(status.value());
        erro.setDateTime(OffsetDateTime.now());
        erro.setTitulo(ex.getMessage());
        return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Erro erro = new Erro();
        erro.setStatus(status.value());
        erro.setDateTime(OffsetDateTime.now());
        erro.setTitulo(ex.getMessage());
        return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
    }
}

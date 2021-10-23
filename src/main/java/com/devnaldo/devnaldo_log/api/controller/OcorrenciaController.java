package com.devnaldo.devnaldo_log.api.controller;

import com.devnaldo.devnaldo_log.api.mapper.OcorrenciaMapper;
import com.devnaldo.devnaldo_log.api.model.OcorrênciaModel;
import com.devnaldo.devnaldo_log.api.model.input.OcorrenciaInput;
import com.devnaldo.devnaldo_log.domain.model.Entrega;
import com.devnaldo.devnaldo_log.domain.model.Ocorrencia;
import com.devnaldo.devnaldo_log.domain.service.BuscaEntregaService;
import com.devnaldo.devnaldo_log.domain.service.OcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entrega/{entregaId}/ocorrencia")
@AllArgsConstructor
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private OcorrenciaService ocorrenciaService;
    private OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrênciaModel registrar(@PathVariable Long entregaId,
                                     @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {

      Ocorrencia ocorrenciaRegistrada = ocorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());

      return ocorrenciaMapper.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrênciaModel> listar(@PathVariable Long entregaId){

        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaMapper.toCollectionModel(entrega.getOcorrencias());

    }

}

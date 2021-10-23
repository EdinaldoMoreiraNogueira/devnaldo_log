package com.devnaldo.devnaldo_log.api.controller;

import com.devnaldo.devnaldo_log.api.mapper.EntregaMapper;
import com.devnaldo.devnaldo_log.api.model.EntregaModel;
import com.devnaldo.devnaldo_log.api.model.input.EntregaInputModel;
import com.devnaldo.devnaldo_log.domain.model.Entrega;
import com.devnaldo.devnaldo_log.domain.repository.EntregaRepository;
import com.devnaldo.devnaldo_log.domain.service.EntregaFinalizadaService;
import com.devnaldo.devnaldo_log.domain.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entrega")
@AllArgsConstructor
public class EntregaController {

    private EntregaRepository entregaRepository;
    private EntregaFinalizadaService entregaFinalizadaService;
    private EntregaService entregaService;
    private EntregaMapper entregaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaInputModel entregaInputModel){

        Entrega novaEntrega = entregaMapper.toEntity(entregaInputModel);

        return entregaMapper.toModel(entregaService.solicitar(novaEntrega));
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entreaId){

        entregaFinalizadaService.finalizar(entreaId);
    }

    @GetMapping
    public List<EntregaModel> listar(){
        return entregaMapper.toCollectionModel(entregaRepository.findAll());
    }
    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId){

        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());


    }
}

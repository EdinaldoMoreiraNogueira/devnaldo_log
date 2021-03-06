package com.devnaldo.devnaldo_log.api.mapper;

import com.devnaldo.devnaldo_log.api.model.OcorrĂȘnciaModel;
import com.devnaldo.devnaldo_log.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {

    private ModelMapper modelMapper;

    public OcorrĂȘnciaModel toModel(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia, OcorrĂȘnciaModel.class);
    }

    public List<OcorrĂȘnciaModel>toCollectionModel(List<Ocorrencia> ocorrencias){
        return ocorrencias.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}

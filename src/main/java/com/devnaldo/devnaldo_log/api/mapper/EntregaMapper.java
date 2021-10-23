package com.devnaldo.devnaldo_log.api.mapper;

import com.devnaldo.devnaldo_log.api.model.EntregaModel;
import com.devnaldo.devnaldo_log.api.model.input.EntregaInputModel;
import com.devnaldo.devnaldo_log.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaMapper {

    public ModelMapper modelMapper;

    public EntregaModel toModel(Entrega entrega){
        return modelMapper.map(entrega, EntregaModel.class);
    };

    public List<EntregaModel> toCollectionModel(List<Entrega> entregas){

        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());

    }

    public Entrega toEntity(EntregaInputModel entregaInputModel){

        return modelMapper.map(entregaInputModel, Entrega.class);
    }
}

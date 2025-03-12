package br.com.itau.workshop.mapper;

import br.com.itau.workshop.controller.response.HabilidadeDetalheResponse;
import br.com.itau.workshop.controller.response.HabilidadeResponse;
import br.com.itau.workshop.repository.entity.HabilidadeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HabilidadeMapper {

    HabilidadeResponse toHabilidadeResponse(HabilidadeEntity habilidadeEntity);
    HabilidadeDetalheResponse toHabilidadeDetalheResponse(HabilidadeEntity habilidadeEntity);

    List<HabilidadeDetalheResponse> toHabilidadeDetalheResponse(List<HabilidadeEntity> habilidadeEntityList);
}

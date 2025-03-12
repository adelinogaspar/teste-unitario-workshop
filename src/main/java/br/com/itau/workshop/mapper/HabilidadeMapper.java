package br.com.itau.workshop.mapper;

import br.com.itau.workshop.controller.response.HabilidadeDetalheResponse;
import br.com.itau.workshop.repository.entity.HabilidadeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HabilidadeMapper {

    HabilidadeDetalheResponse toHabilidadeDetalheResponse(HabilidadeEntity habilidadeEntity);
}

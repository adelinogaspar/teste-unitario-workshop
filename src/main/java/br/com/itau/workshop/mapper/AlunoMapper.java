package br.com.itau.workshop.mapper;

import br.com.itau.workshop.controller.request.AlunoDetalheRequest;
import br.com.itau.workshop.controller.response.AlunoDetalheResponse;
import br.com.itau.workshop.controller.response.AlunoResponse;
import br.com.itau.workshop.repository.entity.AlunoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
    @Mapping(target = "nome", source = "nomeReal")
    @Mapping(target = "alcunha", source = "nomeFantasia")
    AlunoResponse toAlunoResponse(AlunoEntity alunoEntity);

    List<AlunoResponse> toAlunoResponse(List<AlunoEntity> alunoEntityList);

    AlunoDetalheResponse toAlunoDetalheResponse(AlunoEntity alunoEntity);

    List<AlunoDetalheResponse> toAlunoDetalheResponse(List<AlunoEntity> alunoEntityList);

    AlunoEntity toAlunoEntity(AlunoDetalheRequest alunoDetalheRequest);
}

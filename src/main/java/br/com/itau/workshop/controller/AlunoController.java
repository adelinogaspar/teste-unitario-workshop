package br.com.itau.workshop.controller;

import br.com.itau.workshop.controller.response.AlunoDetalheResponse;
import br.com.itau.workshop.controller.response.AlunoResponse;
import br.com.itau.workshop.facade.AlunoFacade;
import br.com.itau.workshop.mapper.AlunoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/aluno")
public class AlunoController {
    @Autowired
    AlunoFacade alunoFacade;

    @Autowired
    AlunoMapper alunoMapper;

    @GetMapping
    List<AlunoResponse> getAlunoResumoListaPorNome(
            @RequestParam(value = "nome", required = false)
            String nome
    ) {
        return alunoMapper.toAlunoResponse(alunoFacade.buscarAlunoPorNome(nome));
    }

    @GetMapping("/detalhe")
    List<AlunoDetalheResponse> getAlunoDetalheListaPorNome(
            @RequestParam(value = "nome", required = false)
            String nome
    ) {
        return alunoMapper.toAlunoDetalheResponse(alunoFacade.buscarAlunoPorNome(nome));
    }
}

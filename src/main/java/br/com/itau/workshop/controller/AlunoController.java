package br.com.itau.workshop.controller;

import br.com.itau.workshop.controller.request.AlunoDetalheRequest;
import br.com.itau.workshop.controller.response.AlunoDetalheResponse;
import br.com.itau.workshop.controller.response.AlunoResponse;
import br.com.itau.workshop.facade.AlunoFacade;
import br.com.itau.workshop.mapper.AlunoMapper;
import br.com.itau.workshop.repository.entity.AlunoEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
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

    @PostMapping
    AlunoDetalheResponse cadastraAluno(@RequestBody @Valid AlunoDetalheRequest alunoDetalheRequest) {
        AlunoEntity alunoSalvo = alunoFacade.cadastraAluno(alunoDetalheRequest);
        return alunoMapper.toAlunoDetalheResponse(alunoSalvo);
    }
}

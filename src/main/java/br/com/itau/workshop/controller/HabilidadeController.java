package br.com.itau.workshop.controller;

import br.com.itau.workshop.controller.response.HabilidadeDetalheResponse;
import br.com.itau.workshop.facade.HabilidadeFacade;
import br.com.itau.workshop.mapper.HabilidadeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/habilidade")
public class HabilidadeController {

    @Autowired
    HabilidadeFacade habilidadeFacade;

    @Autowired
    HabilidadeMapper habilidadeMapper;

    @GetMapping
    public List<HabilidadeDetalheResponse> listaHabilidades() {
        return habilidadeMapper.toHabilidadeDetalheResponse(habilidadeFacade.listaHabilidades());
    }
}

package br.com.itau.workshop.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AlunoDetalheRequest {
    String nomeReal;
    String nomeFantasia;
    Integer forca;
    Integer inteligencia;

    List<HabilidadeRequest> habilidades;
}

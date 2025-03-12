package br.com.itau.workshop.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AlunoDetalheResponse {
    String nomeReal;
    String nomeFantasia;
    Integer forca;
    Integer inteligencia;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate dataCadastro;
    List<HabilidadeResponse> habilidades;
}

package br.com.itau.workshop.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AlunoResponse {
    String nome;
    String alcunha;
    LocalDate dataCadastro;
}

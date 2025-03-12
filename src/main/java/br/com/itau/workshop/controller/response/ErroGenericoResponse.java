package br.com.itau.workshop.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErroGenericoResponse {
    Integer status;
    String mensagem;
}

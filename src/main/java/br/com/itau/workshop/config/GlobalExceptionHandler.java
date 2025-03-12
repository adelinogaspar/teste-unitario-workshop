package br.com.itau.workshop.config;

import br.com.itau.workshop.controller.response.ErroGenericoResponse;
import br.com.itau.workshop.facade.exception.AlunoJaCadastradoException;
import br.com.itau.workshop.facade.exception.HabilidadeNaoEncontradaException;
import br.com.itau.workshop.facade.exception.MuitasHabilidadesException;
import br.com.itau.workshop.facade.exception.SemHabilidadesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            errors.append(error.getDefaultMessage()).append("; ");
        });
        return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            MuitasHabilidadesException.class,
            SemHabilidadesException.class,
            HabilidadeNaoEncontradaException.class,
            AlunoJaCadastradoException.class
    })
    public ResponseEntity<ErroGenericoResponse> handleCustomExceptions(RuntimeException ex) {
        ErroGenericoResponse erroGenericoResponse = ErroGenericoResponse.builder()
                .mensagem(ex.getMessage())
                .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .build();
        return new ResponseEntity<>(erroGenericoResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}

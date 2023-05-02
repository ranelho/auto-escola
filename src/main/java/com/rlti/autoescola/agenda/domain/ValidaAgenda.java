package com.rlti.autoescola.agenda.domain;

import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.servico.domain.Categoria;

import static com.rlti.autoescola.handler.APIException.build;
import static com.rlti.autoescola.servico.domain.Categoria.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ValidaAgenda {

    public static void validaInstrutorServico(Instrutor instrutor, Categoria categoria) {
        if (categoria == ACC && instrutor.getCategoria() != ACC) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria ACC");
        } else if (categoria == AB &&
                (instrutor.getCategoria() != A && instrutor.getCategoria() != B && instrutor.getCategoria() != AB)) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria AB, A ou B");
        } else if (categoria == A && instrutor.getCategoria() != A) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria A");
        } else if (categoria == B && instrutor.getCategoria() != B) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria B");
        } else if (categoria == C && instrutor.getCategoria() != C) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria C");
        } else if (categoria == D && instrutor.getCategoria() != D) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria D");
        } else if (categoria == AD &&
                (instrutor.getCategoria() != A && instrutor.getCategoria() != B && instrutor.getCategoria() != C
                        && instrutor.getCategoria() != D && instrutor.getCategoria() != AB)) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria AD, A, B, C, D ou AB");
        }
    }
}

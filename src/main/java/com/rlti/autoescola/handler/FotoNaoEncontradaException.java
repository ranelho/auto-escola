package com.rlti.autoescola.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FotoNaoEncontradaException extends RuntimeException {

    public FotoNaoEncontradaException(String message) {
        super(message);
    }
}


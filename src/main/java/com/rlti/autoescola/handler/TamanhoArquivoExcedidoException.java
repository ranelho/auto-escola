package com.rlti.autoescola.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TamanhoArquivoExcedidoException extends RuntimeException {

    public TamanhoArquivoExcedidoException(String message) {
        super(message);
    }
}
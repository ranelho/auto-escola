package com.rlti.autoescola.cliente.application;

import lombok.Value;

@Value
public class FotoResponse {
    Long id;
    String url;

    public FotoResponse(Long id, String url) {
        this.id = id;
        this.url = url;
    }
}

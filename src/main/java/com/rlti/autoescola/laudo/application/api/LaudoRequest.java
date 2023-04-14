package com.rlti.autoescola.laudo.application.api;

import lombok.Value;

import java.time.LocalDate;

@Value
public class LaudoRequest {
    LocalDate dataEmissao;
    String renach;
}

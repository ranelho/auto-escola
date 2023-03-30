package com.rlti.autoescola.frota.application.api;

import com.rlti.autoescola.frota.domain.Tipo;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class VeiculoRequest {
    @NotNull
    String placa;
    String marca;
    String modelo;
    @NotNull
    String ano;
    Tipo tipo;
}

package com.rlti.autoescola.frota.application.api;

import com.rlti.autoescola.frota.domain.Tipo;
import com.rlti.autoescola.matricula.domain.placa.Placa;
import com.rlti.autoescola.matricula.domain.placa.TipoPlaca;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class VeiculoRequest {
    @NotNull(message = "Placa é obrigatória")
    @Placa(tipo = {TipoPlaca.NORMAL, TipoPlaca.MERCOSUL})
    String placa;
    String marca;
    String modelo;
    @NotNull
    String ano;
    Tipo tipo;
}
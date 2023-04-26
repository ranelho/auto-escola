package com.rlti.autoescola.frota.veiculo.application.api;

import com.rlti.autoescola.frota.veiculo.annotation.PlacaValida;
import com.rlti.autoescola.frota.veiculo.domain.Tipo;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VeiculoRequest {
    @NotNull(message = "Placa é obrigatória")
    @PlacaValida
    String placa;
    String marca;
    String modelo;
    @NotNull
    String ano;
    Tipo tipo;
}
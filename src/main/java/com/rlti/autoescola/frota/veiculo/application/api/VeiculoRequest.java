package com.rlti.autoescola.frota.veiculo.application.api;

import com.rlti.autoescola.frota.veiculo.annotation.PlacaValida;
import com.rlti.autoescola.frota.veiculo.domain.Tipo;
import com.rlti.autoescola.frota.veiculo.domain.placa.TipoPlaca;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VeiculoRequest {
    @NotNull(message = "Placa é obrigatória")
    @PlacaValida(tipo = {TipoPlaca.NORMAL, TipoPlaca.MERCOSUL})
    String placa;
    String marca;
    String modelo;
    @NotNull
    String ano;
    Tipo tipo;
}
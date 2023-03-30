package com.rlti.autoescola.frota.application.api;

import com.rlti.autoescola.frota.domain.Veiculo;
import lombok.Value;

@Value
public class VeiculoResponse {
    String placa;
    String marca;
    String ano;
    String tipo;

    public VeiculoResponse(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.marca = veiculo.getMarca();
        this.ano = veiculo.getAno();
        this.tipo = String.valueOf(veiculo.getTipo());
    }
}

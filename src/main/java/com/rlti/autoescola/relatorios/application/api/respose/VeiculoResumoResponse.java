package com.rlti.autoescola.relatorios.application.api.respose;

import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import lombok.Data;

@Data
public class VeiculoResumoResponse {
    String tipo;
    String placa;

    public VeiculoResumoResponse(Veiculo veiculo) {
        this.tipo = String.valueOf(veiculo.getTipo());
        this.placa = veiculo.getPlaca();
    }
}

package com.rlti.autoescola.frota.application.api;

import com.rlti.autoescola.frota.domain.Veiculo;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<VeiculoResponse> converte(List<Veiculo> veiculos) {
        return veiculos
                .stream()
                .map(VeiculoResponse::new)
                .collect(Collectors.toList());
    }
}

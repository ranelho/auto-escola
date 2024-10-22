package com.rlti.autoescola.frota.veiculo.application.api;

import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class VeiculoResponse {
    UUID idVeiculo;
    String placa;
    String marca;
    String ano;
    String tipo;

    public VeiculoResponse(Veiculo veiculo) {
        this.idVeiculo = veiculo.getIdVeiculo();
        this.placa = veiculo.getPlaca();
        this.marca = veiculo.getMarca();
        this.ano = veiculo.getAno();
        this.tipo = String.valueOf(veiculo.getTipo());
    }

    public static List<VeiculoResponse> converte(List<Veiculo> veiculos) {
        return veiculos
                .stream()
                .map(VeiculoResponse::new)
                .toList();
    }
}
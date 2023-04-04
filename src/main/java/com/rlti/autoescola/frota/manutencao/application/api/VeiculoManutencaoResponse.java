package com.rlti.autoescola.frota.manutencao.application.api;

import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class VeiculoManutencaoResponse {
    UUID idVeiculo;
    String placa;
    String modelo;
    List<ManutencaoListResponse> manutencoes;

    public VeiculoManutencaoResponse(Veiculo veiculo) {
        this.idVeiculo = veiculo.getIdVeiculo();
        this.placa = veiculo.getPlaca();
        this.modelo = veiculo.getModelo();
        this.manutencoes = ManutencaoListResponse.converte(veiculo.getManutencoes());
    }
}

package com.rlti.autoescola.frota.manutencao.application.api;

import com.rlti.autoescola.frota.veiculo.domain.Tipo;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class VeiculoManutencaoResponse {
    UUID idVeiculo;
    String placa;
    String marca;
    String modelo;
    String ano;
    Tipo tipo;
    List<ManutencaoListResponse> manutencaoListResponses;

    public VeiculoManutencaoResponse(Veiculo veiculo) {
        this.idVeiculo = veiculo.getIdVeiculo();
        this.placa = veiculo.getPlaca();
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
        this.tipo = veiculo.getTipo();
        this.manutencaoListResponses = ManutencaoListResponse.converte(veiculo.getManutencoes());
    }
}

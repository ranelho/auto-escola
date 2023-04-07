package com.rlti.autoescola.frota.manutencao.application.api;

import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Value
public class VeiculoManutencaoResponse {
    UUID idVeiculo;
    String placa;
    String modelo;
    BigDecimal gastoTotal;
    List<ManutencaoListResponse> manutencoes;

    public VeiculoManutencaoResponse(Veiculo veiculo) {
        this.idVeiculo = veiculo.getIdVeiculo();
        this.placa = veiculo.getPlaca();
        this.modelo = veiculo.getModelo();
        this.gastoTotal = somaManutencoes(veiculo.getManutencoes());
        this.manutencoes = ManutencaoListResponse.converte(veiculo.getManutencoes());
    }

    private BigDecimal somaManutencoes(List<Manutencao> manutencoes){
        return manutencoes
                .stream()
                .map(Manutencao::getValorManutencao)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

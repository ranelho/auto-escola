package com.rlti.autoescola.relatorios.application.api.respose;

import com.rlti.autoescola.frota.manutencao.application.api.ManutencaoListResponse;
import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RelatorioVeiculosResponse {
    String placa;
    String marca;
    String ano;
    String tipo;
    BigDecimal totalManutencoes;
    List<ManutencaoListResponse> manutencoes;

    public RelatorioVeiculosResponse(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.marca = veiculo.getMarca();
        this.ano = veiculo.getAno();
        this.tipo = veiculo.getTipo().toString();
        this.manutencoes = ManutencaoListResponse.converte(veiculo.getManutencoes());
        this.totalManutencoes = somaDespesa(veiculo.getManutencoes());
    }

    public static List<RelatorioVeiculosResponse> converte(List<Veiculo> veiculos) {
        return veiculos
                .stream()
                .map(RelatorioVeiculosResponse::new)
                .toList();
    }

    private BigDecimal somaDespesa(List<Manutencao> manutencoes) {
        return manutencoes
                .stream()
                .map(Manutencao::getValorManutencao)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

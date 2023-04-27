package com.rlti.autoescola.fluxo.application.api;

import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.frota.manutencao.domain.TipoManutencao;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ManutencaoFluxoResponse {
    String veiculo;
    LocalDate dataManutencao;
    TipoManutencao tipoManutencao;
    BigDecimal valorManutencao;

    public ManutencaoFluxoResponse(Manutencao manutencao) {
        this.veiculo = manutencao.getVeiculo().getTipo().toString() + " - " + manutencao.getVeiculo().getPlaca();
        this.dataManutencao = manutencao.getDataManutencao();
        this.tipoManutencao = manutencao.getTipoManutencao();
        this.valorManutencao = manutencao.getValorManutencao();
    }

    public static List<ManutencaoFluxoResponse> convert(List<Manutencao> manutencao) {
        return manutencao.stream()
                .map(ManutencaoFluxoResponse::new)
                .collect((Collectors.toList()));
    }
}

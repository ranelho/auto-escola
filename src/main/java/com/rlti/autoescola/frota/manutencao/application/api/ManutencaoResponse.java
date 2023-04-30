package com.rlti.autoescola.frota.manutencao.application.api;

import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.frota.manutencao.domain.TipoManutencao;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ManutencaoResponse {
    Long idManutencao;
    String veiculo;
    LocalDate dataManutencao;
    BigDecimal valorManutencao;
    TipoManutencao tipoManutencao;
    String descricao;

    public ManutencaoResponse(Manutencao manutencao) {
        this.idManutencao = manutencao.getIdManutencao();
        this.veiculo = manutencao.getVeiculo().getPlaca();
        this.dataManutencao = manutencao.getDataManutencao();
        this.valorManutencao = manutencao.getValorManutencao();
        this.tipoManutencao = manutencao.getTipoManutencao();
        this.descricao = manutencao.getDescricao();
    }

    public static List<ManutencaoResponse> convert(List<Manutencao> manutencao) {
        return manutencao.stream()
                .map(ManutencaoResponse::new)
                .collect((Collectors.toList()));
    }
}

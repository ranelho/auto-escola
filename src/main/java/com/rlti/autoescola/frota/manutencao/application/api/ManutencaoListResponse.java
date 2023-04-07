package com.rlti.autoescola.frota.manutencao.application.api;

import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.frota.manutencao.domain.TipoManutencao;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Value
public class ManutencaoListResponse {
    Long idManutencao;
    LocalDate dataManutencao;
    BigDecimal valorManutencao;
    TipoManutencao tipoManutencao;

    public ManutencaoListResponse(Manutencao manutencao) {
        this.idManutencao = manutencao.getIdManutencao();
        this.dataManutencao = manutencao.getDataManutencao();
        this.valorManutencao = manutencao.getValorManutencao();
        this.tipoManutencao = manutencao.getTipoManutencao();
    }
    public static List<ManutencaoListResponse> converte(List<Manutencao> servicos) {
        return servicos
                .stream()
                .map(ManutencaoListResponse::new)
                .toList();
    }
}
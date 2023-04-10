package com.rlti.autoescola.frota.manutencao.application.api;

import com.rlti.autoescola.frota.manutencao.domain.TipoManutencao;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class ManutencaoRequest {
    @NotNull
    LocalDate dataManutencao;
    @NotNull
    BigDecimal valorManutencao;
    @NotNull
    TipoManutencao tipoManutencao;
}

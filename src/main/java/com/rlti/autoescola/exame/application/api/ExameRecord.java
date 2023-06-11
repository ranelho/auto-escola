package com.rlti.autoescola.exame.application.api;

import com.rlti.autoescola.exame.domain.Resultado;
import com.rlti.autoescola.exame.domain.TipoExame;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ExameRecord(
        @NotNull
        TipoExame tipoExame,
        @NotNull
        LocalDate dataExame,
        @NotNull
        Resultado resultado,
        String observacao
) {
}

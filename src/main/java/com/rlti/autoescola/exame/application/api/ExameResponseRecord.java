package com.rlti.autoescola.exame.application.api;

import com.rlti.autoescola.exame.domain.Exame;

import java.time.LocalDate;
import java.util.List;

public record ExameResponseRecord(
        Long idExame,
        String tipoExame,
        LocalDate dataExame,
        String resultado,
        String observacao
) {
    public ExameResponseRecord(Exame exame) {
        this(
              exame.getIdExame(),
              exame.getTipoExame().toString(),
              exame.getDataExame(),
              exame.getObservacao(),
              exame.getResultado().toString()
        );
    }

    public static List<ExameResponseRecord> converte(List<Exame> exames) {
        return exames
                .stream()
                .map(ExameResponseRecord::new)
                .toList();
    }
}
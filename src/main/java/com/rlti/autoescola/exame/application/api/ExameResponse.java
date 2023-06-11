package com.rlti.autoescola.exame.application.api;

import com.rlti.autoescola.exame.domain.Exame;

import java.time.LocalDate;
import java.util.List;

public record ExameResponse(Long idExame, String tipoExame, LocalDate dataExame, String resultado, String observacao) {

    public ExameResponse(Exame exame) {
        this(exame.getIdExame(), exame.getTipoExame().toString(), exame.getDataExame(),
                exame.getObservacao(), exame.getResultado().toString());
    }
    public static List<ExameResponse> converte(List<Exame> exames) {
        return exames.stream().map(ExameResponse::new).toList();
    }
}
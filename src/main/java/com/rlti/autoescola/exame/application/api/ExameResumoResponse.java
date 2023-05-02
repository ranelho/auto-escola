package com.rlti.autoescola.exame.application.api;

import com.rlti.autoescola.exame.domain.Exame;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ExameResumoResponse {
    String tipoExame;
    LocalDate dataExame;
    String resultado;

    public ExameResumoResponse(Exame exame) {
        this.tipoExame = exame.getTipoExame().toString();
        this.dataExame = exame.getDataExame();
        this.resultado = exame.getResultado().toString();
    }
    public static List<ExameResumoResponse> converte(List<Exame> exames) {
        return exames
                .stream()
                .map(ExameResumoResponse::new)
                .toList();
    }
}
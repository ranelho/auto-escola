package com.rlti.autoescola.exame.application.api;

import com.rlti.autoescola.exame.domain.Exame;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExameResponse {
    Long idExame;
    String tipoExame;
    LocalDate dataExame;
    String resultado;
    String observacao;

    public ExameResponse(Exame exame) {
        this.idExame = exame.getIdExame();
        this.tipoExame = exame.getTipoExame().toString();
        this.dataExame = exame.getDataExame();
        this.resultado = exame.getResultado().toString();
        this.observacao = exame.getObservacao();
    }
}

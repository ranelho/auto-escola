package com.rlti.autoescola.exame.application.api;

import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.frota.manutencao.application.api.ManutencaoListResponse;
import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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
    public static List<ExameResponse> converte(List<Exame> exames) {
        return exames
                .stream()
                .map(ExameResponse::new)
                .toList();
    }
}

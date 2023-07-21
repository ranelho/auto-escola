package com.rlti.autoescola.laudo.application.api;

import com.rlti.autoescola.laudo.domain.Laudo;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class LaudoResumoResponse {
    String renach;
    LocalDate dataEmissao;
    LocalDate validade;

    public LaudoResumoResponse(Laudo laudo) {
        this.renach = laudo.getRenach();
        this.dataEmissao = laudo.getDataEmissao();
        this.validade = laudo.getValidade();
    }

    public static List<LaudoResumoResponse> converte(List<Laudo> laudos) {
        return laudos.stream()
                .map(LaudoResumoResponse::new)
                .toList();
    }
}
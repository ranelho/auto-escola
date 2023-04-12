package com.rlti.autoescola.laudo.application.api;

import com.rlti.autoescola.laudo.domain.Laudo;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class LaudoResponse {
    Long idLaudo;
    String renach;
    String cpf;
    String fullName;
    LocalDate dataEmissao;
    LocalDate validade;
    String servico;

    public LaudoResponse(Laudo laudo) {
        this.idLaudo = laudo.getIdLaudo();
        this.renach = laudo.getRenach();
        this.cpf = laudo.getMatricula().getCliente().getCpf();
        this.fullName = laudo.getMatricula().getCliente().getFullName();
        this.dataEmissao = laudo.getDataEmissao();
        this.validade = laudo.getValidade();
        this.servico = laudo.getMatricula().getServico().getCategoria().toString();
    }

    public static List<LaudoResponse> converte(List<Laudo> laudos) {
        return laudos.stream()
                .map(LaudoResponse::new)
                .collect((Collectors.toList()));
    }
}

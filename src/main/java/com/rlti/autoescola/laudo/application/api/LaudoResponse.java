package com.rlti.autoescola.laudo.application.api;

import com.rlti.autoescola.laudo.domain.Laudo;
import lombok.Value;

import java.time.LocalDate;

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
}

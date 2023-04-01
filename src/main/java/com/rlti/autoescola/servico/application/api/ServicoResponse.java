package com.rlti.autoescola.servico.application.api;

import com.rlti.autoescola.servico.domain.Servico;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Value
public class ServicoResponse {
    UUID idServico;
    String categoria;
    BigDecimal valorServico;

    public ServicoResponse(Servico servico) {
        this.idServico = servico.getIdServico();
        this.categoria = servico.getCategoria().toString();
        this.valorServico = servico.getValorServico();
    }

    public static List<ServicoResponse> converte(List<Servico> servicos) {
        return servicos
                .stream()
                .map(ServicoResponse::new)
                .toList();
    }
}
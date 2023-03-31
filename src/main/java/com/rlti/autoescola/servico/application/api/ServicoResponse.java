package com.rlti.autoescola.servico.application.api;

import com.rlti.autoescola.servico.domain.Servico;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ServicoResponse {
    String categoria;
    BigDecimal valorServico;

    public ServicoResponse(Servico servico) {
        this.categoria = servico.getCategoria().toString();
        this.valorServico = servico.getValorServico();
    }
}
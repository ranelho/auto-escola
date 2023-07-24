package com.rlti.autoescola.fluxo.application.api;

import com.rlti.autoescola.fluxo.domain.Fluxo;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ReceitaPagamentoResponse {
    TipoPagamento tipoPagamento;
    BigDecimal valorRecebido;

    public ReceitaPagamentoResponse(Fluxo fluxo) {
        this.tipoPagamento = fluxo.getTipoPagamento();
        this.valorRecebido = fluxo.getValorTotalReceitas();
    }

    public static List<ReceitaPagamentoResponse> converte(List<Fluxo> fluxos) {
        return fluxos.stream()
                .map(ReceitaPagamentoResponse::new)
                .collect(Collectors.toList());
    }
}

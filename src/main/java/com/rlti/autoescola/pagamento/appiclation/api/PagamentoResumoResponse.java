package com.rlti.autoescola.pagamento.appiclation.api;

import com.rlti.autoescola.pagamento.domain.Pagamento;

import java.math.BigDecimal;
import java.util.List;

public record PagamentoResumoResponse(
        BigDecimal valorContratado,
        BigDecimal valorPago
) {

    public PagamentoResumoResponse(Pagamento pagamento) {
        this(pagamento.getMatricula().getValorFinal(), pagamento.getValorPago());
    }

    public static List<PagamentoResumoResponse> convert(List<Pagamento> pagamento) {
        return pagamento.stream()
                .map(PagamentoResumoResponse::new)
                .toList();
    }
}

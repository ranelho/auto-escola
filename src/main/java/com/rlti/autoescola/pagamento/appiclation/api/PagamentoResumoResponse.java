package com.rlti.autoescola.pagamento.appiclation.api;

import com.rlti.autoescola.pagamento.domain.Pagamento;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class PagamentoResumoResponse {
    BigDecimal valorContratado;
    BigDecimal valorPago;

    public PagamentoResumoResponse(Pagamento pagamento) {
        this.valorContratado = pagamento.getMatricula().getValorFinal();
        this.valorPago = pagamento.getValorPago();
    }

    public static List<PagamentoResumoResponse> convert(List<Pagamento> pagamento) {
        return pagamento.stream()
                .map(PagamentoResumoResponse::new)
                .collect((Collectors.toList()));
    }
}

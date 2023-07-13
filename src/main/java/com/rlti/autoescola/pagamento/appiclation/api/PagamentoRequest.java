package com.rlti.autoescola.pagamento.appiclation.api;

import com.rlti.autoescola.matricula.domain.TipoPagamento;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class PagamentoRequest {
    @NotNull
    TipoPagamento tipoPagamento;
    @NotNull
    BigDecimal valorPago;
}
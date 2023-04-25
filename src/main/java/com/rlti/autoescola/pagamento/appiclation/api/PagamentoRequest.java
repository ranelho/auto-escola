package com.rlti.autoescola.pagamento.appiclation.api;

import com.rlti.autoescola.matricula.domain.TipoPagamento;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class PagamentoRequest {
    TipoPagamento tipoPagamento;
    BigDecimal valorPago;
}
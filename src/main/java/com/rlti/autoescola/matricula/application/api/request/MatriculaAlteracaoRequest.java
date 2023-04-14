package com.rlti.autoescola.matricula.application.api.request;

import com.rlti.autoescola.matricula.domain.Status;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class MatriculaAlteracaoRequest {
    TipoPagamento tipoPagamento;
    BigDecimal valorEntrada;
    int desconto;
    int quantidadeParcelas;
    String observacao;
    Status status;
}

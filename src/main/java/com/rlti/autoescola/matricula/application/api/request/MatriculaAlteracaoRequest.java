package com.rlti.autoescola.matricula.application.api.request;

import com.rlti.autoescola.matricula.domain.TipoPagamento;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Value
public class MatriculaAlteracaoRequest {
    TipoPagamento tipoPagamento;
    BigDecimal valorEntrada;
    int desconto;
    @Min(value = 1, message = "O valor mínimo é 1")
    @Max(value = 12, message = "O valor máximo é 12")
    int quantidadeParcelas;
    String observacao;
}
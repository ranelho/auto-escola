package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.domain.TipoPagamento;
import lombok.Value;

@Value
public class MatriculaAlteracaoRequest {
    TipoPagamento tipoPagamento;
    Double valorEntrada;
    int desconto;
    int quantidadeParcelas;
    String observacao;
}

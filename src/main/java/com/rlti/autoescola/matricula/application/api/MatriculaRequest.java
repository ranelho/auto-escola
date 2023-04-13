package com.rlti.autoescola.matricula.application.api;

import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.matricula.domain.TipoServico;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.UUID;

@Value
public class MatriculaRequest {
    UUID idCliente;
    UUID idServico;
    TipoPagamento tipoPagamento;
    BigDecimal valorEntrada;
    int desconto;
    @Min(value = 1, message = "O valor mínimo é 1")
    @Max(value = 12, message = "O valor máximo é 12")
    int quantidadeParcelas;
    String observacao;
    TipoServico tipoServico;
}

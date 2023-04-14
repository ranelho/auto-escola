package com.rlti.autoescola.matricula.application.api.request;

import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.matricula.domain.TipoServico;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class SolicitacaoRequest {
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
package com.rlti.autoescola.matricula.application.api.request;

import com.rlti.autoescola.matricula.annotation.TipoPagamentoEntradaConstraint;
import com.rlti.autoescola.matricula.annotation.ValidSolicitacaoRequest;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.matricula.domain.TipoServico;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@ValidSolicitacaoRequest
public class SolicitacaoRequest {
    UUID idServico;
    //TODO -> VALIDAÇÃO PARA TIPO DE PAGAMENTO
    @NotNull(message = "O tipo de pagamento não pode ser nulo")
    TipoPagamento tipoPagamento;
    @DecimalMin(message = "O valor de entrada não pode ser negativo", value = "0.0")
    BigDecimal valorEntrada;
    int desconto;
    @Min(value = 1, message = "O valor mínimo é 1")
    @Max(value = 12, message = "O valor máximo é 12")
    int quantidadeParcelas;
    @TipoPagamentoEntradaConstraint()
    String tipoPagamentoEntrada;
    String observacao;
    @NotNull(message = "O tipo de serviço não pode ser nulo")
    TipoServico tipoServico;
}
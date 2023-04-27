package com.rlti.autoescola.matricula.application.api.request;

import com.rlti.autoescola.matricula.annotation.TipoPagamentoEntradaConstraint;
import com.rlti.autoescola.matricula.annotation.ValidSolicitacaoRequest;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.matricula.domain.TipoServico;
import lombok.Data;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@ValidSolicitacaoRequest
public class SolicitacaoRequest {
    UUID idServico;
    @NotNull(message = "O tipo de pagamento não pode ser nulo")
    TipoPagamento tipoPagamento;
    @DecimalMin(message = "O valor de entrada não pode ser negativo", value = "0.0")
    BigDecimal valorEntrada;
    int desconto;
    @Min(value = 1, message = "O valor mínimo é 1")
    @Max(value = 12, message = "O valor máximo é 12")
    int quantidadeParcelas;
    @TipoPagamentoEntradaConstraint(message = "O tipo de pagamento de entrada deve ser DINHEIRO, CARTAO_DEBITO ou PIX")
    String tipoPagamentoEntrada;
    String observacao;
    @NotNull(message = "O tipo de serviço não pode ser nulo")
    TipoServico tipoServico;
}
package com.rlti.autoescola.handler.validacoes;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

public class ValidaParcelamento {
    public static void validarTipoPagamentoETotalParcelas(TipoPagamento tipoPagamento, int quantidadeParcelas) {
        if (tipoPagamento == TipoPagamento.DINHEIRO || tipoPagamento == TipoPagamento.DEBITO) {
            if (quantidadeParcelas != 1) {
                throw APIException.build(HttpStatus.BAD_REQUEST,"Quantidade de parcelas inválida para o tipo de pagamento escolhido.");
            }
        } else if (tipoPagamento == TipoPagamento.CREDITO) {
            if (quantidadeParcelas < 1) {
                throw APIException.build(HttpStatus.BAD_REQUEST,"Quantidade de parcelas inválida para o tipo de pagamento escolhido.");
            }
        }
    }
}
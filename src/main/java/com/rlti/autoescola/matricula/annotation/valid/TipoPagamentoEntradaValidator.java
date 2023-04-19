package com.rlti.autoescola.matricula.annotation.valid;

import com.rlti.autoescola.matricula.annotation.TipoPagamentoEntradaConstraint;
import com.rlti.autoescola.matricula.domain.TipoPagamento;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TipoPagamentoEntradaValidator implements ConstraintValidator<TipoPagamentoEntradaConstraint, String> {
    @Override
    public boolean isValid(String tipoPagamentoEntrada, ConstraintValidatorContext context) {
        if (tipoPagamentoEntrada == "") {
            return true;
        }
        return tipoPagamentoEntrada.equals(TipoPagamento.DINHEIRO.toString()) ||
                tipoPagamentoEntrada.equals(TipoPagamento.CARTAO_DEBITO.toString()) ||
                tipoPagamentoEntrada.equals(TipoPagamento.PIX.toString());
    }
}

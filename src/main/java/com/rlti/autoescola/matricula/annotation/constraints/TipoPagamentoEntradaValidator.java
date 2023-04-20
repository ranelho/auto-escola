package com.rlti.autoescola.matricula.annotation.constraints;

import com.rlti.autoescola.matricula.annotation.TipoPagamentoEntradaConstraint;
import com.rlti.autoescola.matricula.domain.TipoPagamento;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class TipoPagamentoEntradaValidator implements ConstraintValidator<TipoPagamentoEntradaConstraint, String> {
    @Override
    public boolean isValid(String tipoPagamentoEntrada, ConstraintValidatorContext context) {
        if (Objects.equals(tipoPagamentoEntrada, "")) {
            return true;
        }
        return tipoPagamentoEntrada.equals(TipoPagamento.DINHEIRO.toString()) ||
                tipoPagamentoEntrada.equals(TipoPagamento.CARTAO_DEBITO.toString()) ||
                tipoPagamentoEntrada.equals(TipoPagamento.PIX.toString());
    }
}

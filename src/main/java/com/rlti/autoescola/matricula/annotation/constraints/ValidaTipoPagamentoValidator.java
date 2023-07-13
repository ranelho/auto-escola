package com.rlti.autoescola.matricula.annotation.constraints;

import com.rlti.autoescola.matricula.annotation.ValidaTipoPagamento;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidaTipoPagamentoValidator implements ConstraintValidator<ValidaTipoPagamento, TipoPagamento> {
    private String valoresDisponiveis;

    @Override
    public void initialize(ValidaTipoPagamento constraintAnnotation) {
        TipoPagamento[] tiposPagamento = TipoPagamento.values();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tiposPagamento.length; i++) {
            builder.append(tiposPagamento[i]);
            if (i < tiposPagamento.length - 1) {
                builder.append(", ");
            }
        }
        valoresDisponiveis = builder.toString();
    }

    @Override
    public boolean isValid(TipoPagamento tipoPagamento, ConstraintValidatorContext context) {
        if (tipoPagamento == null) {
            return false;
        }

        return true;
    }
}

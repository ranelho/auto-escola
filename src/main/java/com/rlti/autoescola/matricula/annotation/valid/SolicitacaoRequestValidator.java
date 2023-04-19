package com.rlti.autoescola.matricula.annotation.valid;

import com.rlti.autoescola.matricula.annotation.ValidSolicitacaoRequest;
import com.rlti.autoescola.matricula.application.api.request.SolicitacaoRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.Objects;

public class SolicitacaoRequestValidator implements ConstraintValidator<ValidSolicitacaoRequest, SolicitacaoRequest> {
    @Override
    public boolean isValid(SolicitacaoRequest request, ConstraintValidatorContext context) {
        BigDecimal valorEntrada = request.getValorEntrada();
        String tipoPagamentoEntrada = request.getTipoPagamentoEntrada();

        if ((valorEntrada.compareTo(BigDecimal.ZERO) > 0 && tipoPagamentoEntrada.isEmpty()) ||
        valorEntrada.compareTo(BigDecimal.ZERO) == 0 && !Objects.equals(tipoPagamentoEntrada, "")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("O tipo de pagamento de entrada deve ser " +
                            "informado quando o valor de entrada é maior do que zero")
                    .addPropertyNode("tipoPagamentoEntrada")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}

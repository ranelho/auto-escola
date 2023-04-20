package com.rlti.autoescola.matricula.annotation;

import com.rlti.autoescola.matricula.annotation.valid.TipoPagamentoEntradaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoPagamentoEntradaValidator.class)
public @interface TipoPagamentoEntradaConstraint {
    String message() default "O tipo de pagamento de entrada deve ser DINHEIRO, CARTAO_DEBITO ou PIX";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.rlti.autoescola.matricula.annotation;

import com.rlti.autoescola.matricula.annotation.constraints.ValidaTipoPagamentoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidaTipoPagamentoValidator.class)
public @interface ValidaTipoPagamento {
    String message() default "Tipo de pagamento inválido. Tipos de pagamento disponíveis: ${validatedValue.valores}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

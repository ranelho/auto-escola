package com.rlti.autoescola.matricula.annotation;

import com.rlti.autoescola.matricula.annotation.valid.SolicitacaoRequestValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SolicitacaoRequestValidator.class)
public @interface ValidSolicitacaoRequest {
    String message() default "Solicitação inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

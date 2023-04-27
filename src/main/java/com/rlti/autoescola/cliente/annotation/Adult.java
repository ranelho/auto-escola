package com.rlti.autoescola.cliente.annotation;

import com.rlti.autoescola.cliente.annotation.constraints.AdultValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AdultValidator.class)
public @interface Adult {
    String message() default "A idade mínima é de 18 anos.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.rlti.autoescola.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = { TrimStringValidator.class })
@Target(FIELD)
@Retention(RUNTIME)
public @interface TrimString {

    String message() default "o campo não pode conter espaços em branco no inicio ou no final!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

package com.rlti.autoescola.matricula.domain.placa;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PlacaValidator.class)
public @interface Placa {

    String message() default "Placa inválida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Enumerated(EnumType.STRING)
    TipoPlaca[] tipo() default {TipoPlaca.NORMAL, TipoPlaca.MERCOSUL};

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        Placa[] value();
    }
}

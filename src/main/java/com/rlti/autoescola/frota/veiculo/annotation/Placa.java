package com.rlti.autoescola.frota.veiculo.annotation;


import com.rlti.autoescola.frota.veiculo.annotation.constraints.PlacaValidator;
import com.rlti.autoescola.frota.veiculo.domain.placa.TipoPlaca;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
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

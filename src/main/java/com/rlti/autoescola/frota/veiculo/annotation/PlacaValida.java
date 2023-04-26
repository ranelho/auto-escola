package com.rlti.autoescola.frota.veiculo.annotation;


import com.rlti.autoescola.frota.veiculo.annotation.constraints.PlacaValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PlacaValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PlacaValida {
    String message() default "Placa inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


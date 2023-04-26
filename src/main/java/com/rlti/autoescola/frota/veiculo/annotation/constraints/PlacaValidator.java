package com.rlti.autoescola.frota.veiculo.annotation.constraints;

import com.rlti.autoescola.frota.veiculo.annotation.Placa;
import com.rlti.autoescola.frota.veiculo.domain.placa.TipoPlaca;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlacaValidator implements  ConstraintValidator<Placa, String> {
    private TipoPlaca[] tipos;

    public void initialize(Placa constraintAnnotation) {
        this.tipos = constraintAnnotation.tipo();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (TipoPlaca tipo : tipos) {
            String regex = getRegex(tipo);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value.toUpperCase());
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    private String getRegex(TipoPlaca tipo) {
        if (tipo == TipoPlaca.NORMAL) {
            return "[A-Z]{3}-\\d{4}";
        } else if (tipo == TipoPlaca.MERCOSUL) {
            return "[A-Z]{3}[0-9][A-Z][0-9]{2}";
        } else {
            throw new IllegalArgumentException("Tipo de placa inválido");
        }
    }
}

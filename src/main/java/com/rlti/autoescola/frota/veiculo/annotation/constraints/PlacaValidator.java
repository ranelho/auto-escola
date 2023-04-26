package com.rlti.autoescola.frota.veiculo.annotation.constraints;

import com.rlti.autoescola.frota.veiculo.annotation.PlacaValida;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlacaValidator implements ConstraintValidator<PlacaValida, String> {
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String regex = "[A-Z]{3}[ -][0-9][A-Z0-9][A-Z0-9][0-9]{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value.toUpperCase());
        return matcher.matches();
    }
}


package com.rlti.autoescola.security.auth.annotation;

import com.rlti.autoescola.handler.APIException;
import org.springframework.http.HttpStatus;

import java.util.regex.Pattern;

public class EmailValidator {
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static String validateEmailFormat(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if (!pattern.matcher(email).matches()) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Email inválido");
        }
        return email;
    }
}

package com.rlti.autoescola.handler.validacoes;

import com.rlti.autoescola.handler.APIException;
import org.springframework.http.HttpStatus;

import java.util.regex.Pattern;

public class ValidaCpfouCnpj {

    private static final String CPF_PATTERN = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";
    private static final String CNPJ_PATTERN = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}\\-\\d{2}$";

    public static void validateCpfOrCnpj(String cpfOrCnpj) throws APIException {
        if (Pattern.matches(CPF_PATTERN, cpfOrCnpj)) {
            if (!isCpfValid(cpfOrCnpj)) {
                throw APIException.build(HttpStatus.BAD_REQUEST, "CPF inválido");
            }
        } else if (Pattern.matches(CNPJ_PATTERN, cpfOrCnpj)) {
            if (!isCnpjValid(cpfOrCnpj)) {
                throw APIException.build(HttpStatus.BAD_REQUEST, "CNPJ inválido");
            }
        } else {
            throw APIException.build(HttpStatus.BAD_REQUEST, "CPF/CNPJ inválido");
        }
    }

    public static boolean isCpfValid(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); // removes non-digits
        if (cpf.length() != 11) {
            return false;
        }
        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Integer.parseInt(cpf.substring(i, i+1));
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += digits[i] * (10 - i);
        }
        int mod = sum % 11;
        int expectedDigit1 = (mod < 2) ? 0 : (11 - mod);
        if (digits[9] != expectedDigit1) {
            return false;
        }
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += digits[i] * (11 - i);
        }
        mod = sum % 11;
        int expectedDigit2 = (mod < 2) ? 0 : (11 - mod);
        return digits[10] == expectedDigit2;
    }

    public static boolean isCnpjValid(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", ""); // removes non-digits
        if (cnpj.length() != 14) {
            return false;
        }
        int[] digits = new int[14];
        for (int i = 0; i < 14; i++) {
            digits[i] = Integer.parseInt(cnpj.substring(i, i+1));
        }
        int sum = 0;
        int weight = 2;
        for (int i = 11; i >= 0; i--) {
            sum += digits[i] * weight;
            weight = (weight == 9) ? 2 : weight + 1;
        }
        int mod = sum % 11;
        int expectedDigit1 = (mod < 2) ? 0 : (11 - mod);
        if (digits[12] != expectedDigit1) {
            return false;
        }
        sum = 0;
        weight = 2;
        for (int i = 12; i >= 0; i--) {
            sum += digits[i] * weight;
            weight = (weight == 9) ? 2 : weight + 1;
        }
        mod = sum % 11;
        int expectedDigit2 = (mod < 2) ? 0 : (11 - mod);
        return digits[13] == expectedDigit2;
    }
}
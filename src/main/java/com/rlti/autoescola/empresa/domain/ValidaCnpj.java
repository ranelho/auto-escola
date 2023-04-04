package com.rlti.autoescola.empresa.domain;

public class ValidaCnpj {
    public static boolean validarCnpj(String cnpj) {
        // Remove pontos e traços do cnpj
        cnpj = cnpj.replaceAll("[^0-14]", "");

        // Verifica se o cnpj tem 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        boolean todosIguais = true;
        for (int i = 1; i < 14; i++) {
            if (cnpj.charAt(i) != cnpj.charAt(0)) {
                todosIguais = false;
                break;
            }
        }
        if (todosIguais) {
            return false;
        }

        // Calcula os dígitos verificadores do CPF
        int digito1 = calcularDigitoVerificador(cnpj.substring(0, 9));
        int digito2 = calcularDigitoVerificador(cnpj.substring(0, 9) + digito1);

        // Verifica se os dígitos verificadores estão corretos
        return cnpj.equals(cnpj.substring(0, 9) + digito1 + digito2);
    }

    private static int calcularDigitoVerificador(String numeros) {
        int soma = 0;
        for (int i = numeros.length() - 1, j = 2; i >= 0; i--, j++) {
            soma += (numeros.charAt(i) - '0') * j;
        }
        int resto = soma % 11;
        if (resto < 2) {
            return 0;
        } else {
            return 11 - resto;
        }
    }
}

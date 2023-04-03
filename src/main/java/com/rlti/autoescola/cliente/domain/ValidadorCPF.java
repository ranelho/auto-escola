package com.rlti.autoescola.cliente.domain;

public class ValidadorCPF {
    public static boolean validarCPF(String cpf) {
        // Remove pontos e traços do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        boolean todosIguais = true;
        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosIguais = false;
                break;
            }
        }
        if (todosIguais) {
            return false;
        }

        // Calcula os dígitos verificadores do CPF
        int digito1 = calcularDigitoVerificador(cpf.substring(0, 9));
        int digito2 = calcularDigitoVerificador(cpf.substring(0, 9) + digito1);

        // Verifica se os dígitos verificadores estão corretos
        return cpf.equals(cpf.substring(0, 9) + digito1 + digito2);
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

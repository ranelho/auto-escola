package com.rlti.autoescola.handler.validacoes;

import com.rlti.autoescola.handler.APIException;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcularDesconto {
    private static final int DESCONTO_MAXIMO = 100;
    private static final int DESCONTO_MINIMO = 0;

    public static BigDecimal calcularValorFinal(int desconto, BigDecimal valorServico) {
        if (desconto < DESCONTO_MINIMO || desconto > DESCONTO_MAXIMO) {
            throw APIException.build(HttpStatus.BAD_REQUEST,"O desconto deve ser um valor entre 0 e 100");
        }
        if (valorServico.compareTo(BigDecimal.ZERO) <= 0) {
            throw APIException.build(HttpStatus.BAD_REQUEST,"O valor do serviço deve ser maior que zero");
        }
        BigDecimal valorDescontado = valorServico.multiply(new BigDecimal(desconto)).divide(BigDecimal.valueOf(100),
                2, RoundingMode.HALF_UP);
        return valorServico.subtract(valorDescontado);
    }

    public  static void validaEntrada(BigDecimal valorEntrada, BigDecimal valorServico, int desconto){
        BigDecimal valorFinal = calcularValorFinal(desconto, valorServico);
        if(valorEntrada.compareTo(valorServico) > 0){
            throw APIException.build(HttpStatus.BAD_REQUEST,
                    "O valor entrada não pode ser maior que o valor final com desconto. " +
                            "Valor do serviço com desconto é de: " + valorFinal);
        }
    }
}
package com.rlti.autoescola.handler.validacoes;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.matricula.application.api.MatriculaRequest;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;
import com.rlti.autoescola.servico.domain.Servico;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.rlti.autoescola.matricula.domain.ValidaCategoria.isCombinationValid;

public class Validacoes {
    private static final int DESCONTO_MAXIMO = 100;
    private static final int DESCONTO_MINIMO = 0;

    public static void validaMatricula(MatriculaRequest request, Servico servico) {
        isCombinationValid(request.getTipoServico(),servico.getCategoria());
        validarTipoPagamentoETotalParcelas(request.getTipoPagamento(), request.getQuantidadeParcelas());
        validaEntrada(request.getValorEntrada(), servico.getValorServico(), request.getDesconto());
    }

    public static void validaOrcamento(OrcamentoRequest request, Servico servico) {
        isCombinationValid(request.getTipoServico(),servico.getCategoria());
        validarTipoPagamentoETotalParcelas(request.getTipoPagamento(), request.getQuantidadeParcelas());
        validaEntrada(request.getValorEntrada(), servico.getValorServico(), request.getDesconto());
    }

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

    public static void validarTipoPagamentoETotalParcelas(TipoPagamento tipoPagamento, int quantidadeParcelas) {
        if (tipoPagamento == TipoPagamento.DINHEIRO || tipoPagamento == TipoPagamento.DEBITO) {
            if (quantidadeParcelas != 1) {
                throw APIException.build(HttpStatus.BAD_REQUEST,"Quantidade de parcelas inválida para o tipo de pagamento escolhido.");
            }
        } else if (tipoPagamento == TipoPagamento.CREDITO) {
            if (quantidadeParcelas < 1) {
                throw APIException.build(HttpStatus.BAD_REQUEST,"Quantidade de parcelas inválida para o tipo de pagamento escolhido.");
            }
        }
    }
}
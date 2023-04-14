package com.rlti.autoescola.matricula.domain;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.matricula.application.api.request.SolicitacaoRequest;
import com.rlti.autoescola.servico.domain.Categoria;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class Validacoes {
    private static final int DESCONTO_MAXIMO = 100;
    private static final int DESCONTO_MINIMO = 0;

    public static void validaSolicitacao(SolicitacaoRequest request, Servico servico) {
        isCombinationValid(request.getTipoServico(),servico.getCategoria());
        validarTipoPagamentoETotalParcelas(request.getTipoPagamento(), request.getQuantidadeParcelas());
        validaEntrada(request.getValorEntrada(), servico.getValorServico(), request.getDesconto());
    }

    private static void isCombinationValid(TipoServico tipoServico, Categoria categoria) {
        if (!tipoServico.isValidCategoria(categoria)) {
            throw APIException
                    .build(HttpStatus.BAD_REQUEST,"Categoria: "+ categoria + " não é compativel com o servico: " + tipoServico);
        }
    }

    public static void validarTipoPagamentoETotalParcelas(TipoPagamento tipoPagamento, int quantidadeParcelas) {
        if (tipoPagamento == TipoPagamento.DINHEIRO || tipoPagamento == TipoPagamento.DEBITO) {
            if (quantidadeParcelas != 1) {
                throw APIException
                        .build(HttpStatus.BAD_REQUEST,"Quantidade de parcelas inválida para o tipo de pagamento escolhido.");
            }
        } else if (tipoPagamento == TipoPagamento.CREDITO) {
            if (quantidadeParcelas < 1) {
                throw APIException
                        .build(HttpStatus.BAD_REQUEST,"Quantidade de parcelas inválida para o tipo de pagamento escolhido.");
            }
        }
    }

    public  static void validaEntrada(BigDecimal valorEntrada, BigDecimal valorServico, int desconto){
        BigDecimal valorFinal = calcularValorFinal(desconto, valorServico);
        if(valorEntrada.compareTo(valorServico) > 0){
            throw APIException
                    .build(HttpStatus.BAD_REQUEST,"Valor entrada R$ :"+valorEntrada + " maior que o valor contratado, " +
                            "Valor Serviço R$: " + valorServico + " - desconto de " + desconto+"% igual a R$: " + valorFinal);
        }
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
}
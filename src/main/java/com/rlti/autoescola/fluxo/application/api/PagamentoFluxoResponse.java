package com.rlti.autoescola.fluxo.application.api;

import com.rlti.autoescola.pagamento.domain.Pagamento;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class PagamentoFluxoResponse {
    String cliente;
    LocalDate dataPagamento;
    String servico;
    BigDecimal valorPago;

    public PagamentoFluxoResponse(Pagamento pagamento) {
        this.cliente = pagamento.getMatricula().getCliente().getFullName();
        this.dataPagamento = pagamento.getDataPagamento();
        this.servico = pagamento.getMatricula().getServico().getCategoria().toString();
        this.valorPago = pagamento.getValorPago();

    }

    public static List<PagamentoFluxoResponse> convert(List<Pagamento> pagamento) {
        return pagamento.stream()
                .map(PagamentoFluxoResponse::new)
                .collect((Collectors.toList()));
    }
}

package com.rlti.autoescola.pagamento.appiclation.api;

import com.rlti.autoescola.pagamento.domain.Pagamento;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class PagamentoResponse {
    Long recibo;
    String cpf;
    String fullName;
    String servico;
    BigDecimal valorContratado;
    BigDecimal valorPago;

    public PagamentoResponse(Pagamento pagamento) {
        this.recibo = pagamento.getIdPagamento();
        this.cpf = ocultarDocumento(pagamento.getMatricula().getCliente().getCpf());
        this.fullName = pagamento.getMatricula().getCliente().getFullName();
        this.servico = pagamento.getMatricula().getServico().getCategoria().toString();
        this.valorContratado = pagamento.getMatricula().getValorFinal();
        this.valorPago = pagamento.getValorPago();
    }

    public static List<PagamentoResponse> convert(List<Pagamento> pagamento) {
        return pagamento.stream()
                .map(PagamentoResponse::new)
                .collect((Collectors.toList()));
    }

    public static String ocultarDocumento(String documento) {
        return documento.replaceAll("\\d{3}\\.\\d{3}", "xxx.xxx");
    }
}

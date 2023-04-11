package com.rlti.autoescola.orcamento.application.api;

import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.orcamento.domain.Orcamento;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrcamentoResponse {
    String cpf;
    String fullName;
    Long idOrcamento;
    TipoPagamento tipoPagamento;
    LocalDate dataOrcamento;
    Double valorEntrada;
    int desconto;
    int quantidadeParcelas;
    String observacao;
    LocalDate validade;
    BigDecimal valorFinal;

    public OrcamentoResponse(Orcamento orcamento) {
        this.cpf = orcamento.getCliente().getCpf();
        this.fullName = orcamento.getCliente().getFullName();
        this.idOrcamento = orcamento.getIdOrcamento();
        this.tipoPagamento = orcamento.getTipoPagamento();
        this.dataOrcamento = orcamento.getDataOrcamento();
        this.valorEntrada = orcamento.getValorEntrada();
        this.desconto = orcamento.getDesconto();
        this.quantidadeParcelas = orcamento.getQuantidadeParcelas();
        this.observacao = orcamento.getObservacao();
        this.validade = orcamento.getValidade();
        this.valorFinal = orcamento.getValorFinal();
    }
}

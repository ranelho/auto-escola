package com.rlti.autoescola.orcamento.application.api;

import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.orcamento.domain.Orcamento;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrcamentoResponse {
    Long idOrcamento;
    String cpf;
    String fullName;
    TipoPagamento tipoPagamento;
    LocalDate dataOrcamento;
    Double valorEntrada;
    int desconto;
    int quantidadeParcelas;
    String observacao;
    LocalDate validade;
    BigDecimal valorFinal;

    public OrcamentoResponse(Orcamento orcamento) {
        this.idOrcamento = orcamento.getIdOrcamento();
        this.cpf = orcamento.getCliente().getCpf();
        this.fullName = orcamento.getCliente().getFullName();
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

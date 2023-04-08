package com.rlti.autoescola.orcamento.application.api;

import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.orcamento.domain.Orcamento;
import lombok.Value;

import javax.validation.Valid;
import java.time.LocalDate;

@Value
public class OrcamentoResponse {
    Long idOrcamento;
    TipoPagamento tipoPagamento;
    LocalDate dataOrcamento;
    Double valorEntrada;
    int desconto;
    int quantidadeParcelas;
    String observacao;
    LocalDate validade;

    public OrcamentoResponse(Orcamento orcamento) {
        this.idOrcamento = orcamento.getIdOrcamento();
        this.tipoPagamento = orcamento.getTipoPagamento();
        this.dataOrcamento = orcamento.getDataOrcamento();
        this.valorEntrada = orcamento.getValorEntrada();
        this.desconto = orcamento.getDesconto();
        this.quantidadeParcelas = orcamento.getQuantidadeParcelas();
        this.observacao = orcamento.getObservacao();
        this.validade = orcamento.getValidade();
    }
}

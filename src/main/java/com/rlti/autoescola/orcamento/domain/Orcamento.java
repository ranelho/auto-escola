package com.rlti.autoescola.orcamento.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.handler.validacoes.CalcularDesconto;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrcamento;

    @OneToOne
    @JsonIgnore
    private Cliente cliente;

    @OneToOne
    @JsonIgnore
    private Servico servico;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    protected LocalDate dataOrcamento;
    private Double valorEntrada;
    private int desconto;
    private int quantidadeParcelas;
    private String observacao;
    private LocalDate validade;
    private BigDecimal valorFinal;

    public Orcamento(Cliente cliente, Servico servico, OrcamentoRequest orcamentoRequest) {
        this.cliente = cliente;
        this.servico = servico;
        this.tipoPagamento = orcamentoRequest.getTipoPagamento();
        this.dataOrcamento = orcamentoRequest.getDataOrcamento();
        this.valorEntrada = orcamentoRequest.getValorEntrada();
        this.desconto = orcamentoRequest.getDesconto();
        this.quantidadeParcelas = orcamentoRequest.getQuantidadeParcelas();
        this.observacao = orcamentoRequest.getObservacao();
        this.validade = orcamentoRequest.getValidade();
        this.valorFinal = CalcularDesconto.calcularValorFinal(orcamentoRequest.getDesconto(), servico.getValorServico());
    }
}

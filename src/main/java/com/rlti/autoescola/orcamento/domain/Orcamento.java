package com.rlti.autoescola.orcamento.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.matricula.annotation.valid.Validacoes;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.matricula.domain.TipoServico;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    protected LocalDate dataOrcamento = LocalDate.now();
    private BigDecimal valorEntrada;
    private int desconto;
    @Min(value = 1, message = "O valor mínimo é 1")
    @Max(value = 12, message = "O valor máximo é 12")
    private int quantidadeParcelas;
    private String observacao;
    private LocalDate validade = dataOrcamento.plusDays(5);
    private BigDecimal valorFinal;

    @Enumerated(EnumType.STRING)
    private TipoServico tipoServico;

    public Orcamento(Cliente cliente, Servico servico, OrcamentoRequest orcamentoRequest) {
        this.cliente = cliente;
        this.servico = servico;
        this.tipoPagamento = orcamentoRequest.getTipoPagamento();
        this.valorEntrada = orcamentoRequest.getValorEntrada();
        this.desconto = orcamentoRequest.getDesconto();
        this.quantidadeParcelas = orcamentoRequest.getQuantidadeParcelas();
        this.observacao = orcamentoRequest.getObservacao();
        this.valorFinal = Validacoes.calcularValorFinal(orcamentoRequest.getDesconto(), servico.getValorServico());
        this.tipoServico = orcamentoRequest.getTipoServico();
    }
}
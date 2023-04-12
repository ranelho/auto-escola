package com.rlti.autoescola.matricula.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.handler.validacoes.CalcularDesconto;
import com.rlti.autoescola.laudo.domain.Laudo;
import com.rlti.autoescola.matricula.application.api.MatriculaAlteracaoRequest;
import com.rlti.autoescola.matricula.application.api.MatriculaRequest;
import com.rlti.autoescola.orcamento.domain.Orcamento;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idMatricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orcamento_id")
    @JsonIgnore
    private Orcamento orcamento;

    @OneToOne
    @JsonIgnore
    private Servico servico;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    private Double valorEntrada;
    private int desconto;
    private int quantidadeParcelas;
    private BigDecimal valorFinal;
    private LocalDate dataMatricula = LocalDate.now();
    private String observacao;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "matricula")
    @JsonIgnore
    private List<Pagamento> pagamentos;

    @OneToOne
    @JsonIgnore
    private Laudo laudo;

    public Matricula(Cliente cliente, Servico servico,  MatriculaRequest matriculaRequest) {
        this.cliente = cliente;
        this.servico = servico;
        this.tipoPagamento = matriculaRequest.getTipoPagamento();
        this.valorEntrada = matriculaRequest.getValorEntrada();
        this.desconto = matriculaRequest.getDesconto();
        this.quantidadeParcelas = matriculaRequest.getQuantidadeParcelas();
        this.observacao = matriculaRequest.getObservacao();
        this.valorFinal = CalcularDesconto.calcularValorFinal(matriculaRequest.getDesconto(), servico.getValorServico());
    }

    public void altera(MatriculaAlteracaoRequest matriculaAlteracaoRequest) {
        this.tipoPagamento = matriculaAlteracaoRequest.getTipoPagamento();
        this.valorEntrada = matriculaAlteracaoRequest.getValorEntrada();
        this.desconto = matriculaAlteracaoRequest.getDesconto();
        this.quantidadeParcelas = matriculaAlteracaoRequest.getQuantidadeParcelas();
        this.observacao = matriculaAlteracaoRequest.getObservacao();
    }
}
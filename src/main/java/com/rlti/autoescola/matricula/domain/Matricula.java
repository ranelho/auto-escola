package com.rlti.autoescola.matricula.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.laudo.domain.Laudo;
import com.rlti.autoescola.matricula.application.api.request.MatriculaAlteracaoRequest;
import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;
import com.rlti.autoescola.orcamento.domain.Orcamento;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.rlti.autoescola.matricula.annotation.constraints.Valid.calcularValorFinal;

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

    @OneToOne
    @JsonIgnore
    private Servico servico;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    private BigDecimal valorEntrada;
    private int desconto;
    @Min(value = 1, message = "O valor mínimo é 1")
    @Max(value = 12, message = "O valor máximo é 12")
    private int quantidadeParcelas;
    private BigDecimal valorFinal;
    private LocalDate dataMatricula = LocalDate.now();
    private String observacao;
    @Enumerated(EnumType.STRING)
    private TipoServico tipoServico;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVA;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "matricula")
    @JsonIgnore
    private List<Pagamento> pagamentos;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "matricula")
    @JsonIgnore
    private List<Laudo> laudo;

    public Matricula(Cliente cliente, Servico servico,  MatriculaRequest matriculaRequest) {
        this.cliente = cliente;
        this.servico = servico;
        this.tipoPagamento = matriculaRequest.getTipoPagamento();
        this.valorEntrada = matriculaRequest.getValorEntrada();
        this.desconto = matriculaRequest.getDesconto();
        this.quantidadeParcelas = matriculaRequest.getQuantidadeParcelas();
        this.observacao = matriculaRequest.getObservacao().toUpperCase();
        this.valorFinal = calcularValorFinal(matriculaRequest.getDesconto(), servico.getValorServico());
        this.tipoServico = matriculaRequest.getTipoServico();
    }

    public Matricula(Orcamento orcamento) {
        this.cliente = orcamento.getCliente();
        this.servico = orcamento.getServico();
        this.tipoPagamento = orcamento.getTipoPagamento();
        this.valorEntrada = orcamento.getValorEntrada();
        this.desconto = orcamento.getDesconto();
        this.quantidadeParcelas = orcamento.getQuantidadeParcelas();
        this.observacao = orcamento.getObservacao().toUpperCase();
        this.valorFinal = orcamento.getValorFinal();
        this.tipoServico = orcamento.getTipoServico();
    }

    public void altera(MatriculaAlteracaoRequest matriculaAlteracaoRequest) {
        this.tipoPagamento = matriculaAlteracaoRequest.getTipoPagamento();
        this.valorEntrada = matriculaAlteracaoRequest.getValorEntrada();
        this.desconto = matriculaAlteracaoRequest.getDesconto();
        this.quantidadeParcelas = matriculaAlteracaoRequest.getQuantidadeParcelas();
        this.observacao = matriculaAlteracaoRequest.getObservacao().toUpperCase();
    }

    public void finalizaMatricula() {
        this.status = Status.INATIVA;
    }

    public void ativaMatricula() { this.status = Status.ATIVA; }

    public void cancelaMatricula() { this.status = Status.CANCELADA; }
}
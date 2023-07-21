package com.rlti.autoescola.matricula.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.laudo.domain.Laudo;
import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;
import com.rlti.autoescola.matricula.application.api.request.MatriculaUpdateRequest;
import com.rlti.autoescola.orcamento.domain.Orcamento;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import com.rlti.autoescola.servico.domain.Servico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.rlti.autoescola.matricula.annotation.constraints.ValidaMatricula.calculaValorFinal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
    private int quantidadeParcelas;
    private BigDecimal valorFinal;
    @CreatedDate
    private LocalDateTime dataMatricula;
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
    private List<Laudo> laudos;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "matricula")
    @JsonIgnore
    List<Exame> exames;

    public Matricula(Cliente cliente, Servico servico,  MatriculaRequest matriculaRequest) {
        this.cliente = cliente;
        this.servico = servico;
        this.tipoPagamento = matriculaRequest.getTipoPagamento();
        this.valorEntrada = matriculaRequest.getValorEntrada();
        this.desconto = matriculaRequest.getDesconto();
        this.quantidadeParcelas = matriculaRequest.getQuantidadeParcelas();
        this.observacao = matriculaRequest.getObservacao().toUpperCase();
        this.valorFinal = calculaValorFinal(matriculaRequest.getDesconto(), servico.getValorServico());
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

    public void altera(MatriculaUpdateRequest matriculaUpdateRequest) {
        this.tipoPagamento = matriculaUpdateRequest.getTipoPagamento();
        this.valorEntrada = matriculaUpdateRequest.getValorEntrada();
        this.desconto = matriculaUpdateRequest.getDesconto();
        this.quantidadeParcelas = matriculaUpdateRequest.getQuantidadeParcelas();
        this.observacao = matriculaUpdateRequest.getObservacao().toUpperCase();
    }

    public void finalizaMatricula() {
        this.status = Status.INATIVA;
    }

    public void ativaMatricula() { this.status = Status.ATIVA; }

    public void cancelaMatricula() { this.status = Status.CANCELADA; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Matricula matricula = (Matricula) o;
        return getIdMatricula() != null && Objects.equals(getIdMatricula(), matricula.getIdMatricula());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
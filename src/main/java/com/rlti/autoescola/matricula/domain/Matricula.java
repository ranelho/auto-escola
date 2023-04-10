package com.rlti.autoescola.matricula.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.laudo.domain.Laudo;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @OneToOne
    @JsonIgnore
    private Servico servico;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    @Enumerated(EnumType.STRING)
    private TipoServico tipoServico;

    private LocalDate dataMatricula;
    private Double valorEntrada;
    private int desconto;
    private int quantidadeParcelas;
    private String observacao;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "matricula")
    @JsonIgnore
    private List<Pagamento> pagamentos;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "matricula")
    @JsonIgnore
    List<Agenda> agenda;

    @OneToOne
    @JsonIgnore
    private Laudo laudo;
}

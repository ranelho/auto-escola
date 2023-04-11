package com.rlti.autoescola.orcamento.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class orcamento {
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
}

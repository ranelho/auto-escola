package com.rlti.autoescola.matricula.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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

    private Servico servico;

    @Enumerated(EnumType.STRING)
    private Pagamento tipoPagamento;

    private LocalDate dataMatricula;
    private Double valorEntrada;
    private int desconto;

    private int quantidadeParcelas;

    private String observacao;

}

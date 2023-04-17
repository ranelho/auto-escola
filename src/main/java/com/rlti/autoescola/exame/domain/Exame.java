package com.rlti.autoescola.exame.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.exame.application.api.ExameRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExame;
    @Enumerated(EnumType.STRING)
    private TipoExame tipoExame;
    private LocalDate dataExame;
    @Enumerated(EnumType.STRING)
    private Resultado resultado;
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    public Exame(Cliente cliente, ExameRequest request) {
        this.cliente = cliente;
        this.tipoExame = request.getTipoExame();
        this.dataExame = request.getDataExame();
        this.resultado = request.getResultado();
        this.observacao = request.getObservacao();
    }

    public void alterar(ExameRequest request) {
        this.tipoExame = request.getTipoExame();
        this.dataExame = request.getDataExame();
        this.resultado = request.getResultado();
        this.observacao = request.getObservacao();
    }
}

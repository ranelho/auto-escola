package com.rlti.autoescola.exame.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
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
    private Matricula matricula;

    public Exame(Matricula matricula, ExameRequest request) {
        this.matricula = matricula;
        this.tipoExame = request.getTipoExame();
        this.dataExame = request.getDataExame();
        this.resultado = request.getResultado();
        this.observacao = request.getObservacao();
    }

    public void altera(Resultado request) {
        this.resultado = request;
    }

    // TODO -> validar tipo de exame na sequencia, CLINICO, TEORICO, PRATICO. cada matricula tem que ter esse processo,
    //  caso reprovado tem que refazer, entao é preciso estar aprovado    para ir para o proximo estagio.
}
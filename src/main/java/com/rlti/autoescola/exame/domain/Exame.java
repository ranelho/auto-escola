package com.rlti.autoescola.exame.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.exame.application.api.ExameRecord;
import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.exame.application.api.ResultadoRequest;
import com.rlti.autoescola.matricula.domain.Matricula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_exame")
    @SequenceGenerator(name = "sequence_exame", sequenceName = "sequence_exame")
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

    public Exame(Matricula matricula, ExameRecord record) {
        this.matricula = matricula;
        this.tipoExame = record.tipoExame();
        this.dataExame = record.dataExame();
        this.resultado = record.resultado();
        this.observacao = record.observacao();
    }

    public Exame( TipoExame tipoExame, LocalDate dataExame, Resultado resultado, String observacao) {
        this.tipoExame = tipoExame;
        this.dataExame = dataExame;
        this.resultado = resultado;
        this.observacao = observacao;
    }

    public void altera(ResultadoRequest request) {
        this.resultado = request.getResultado();
    }
}
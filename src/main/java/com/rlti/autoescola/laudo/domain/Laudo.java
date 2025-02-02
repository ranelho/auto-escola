package com.rlti.autoescola.laudo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.laudo.application.api.LaudoRequest;
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
public class Laudo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_laudo")
    @SequenceGenerator(name = "sequence_laudo", sequenceName = "sequence_laudo")
    private Long idLaudo;
    private LocalDate dataEmissao;
    private LocalDate validade;    /* 1 ANO APÓS A DATA DE EMISSÃO */
    @Column(unique = true, updatable = true)
    private String renach;         /* BA512150325 */

    @ManyToOne
    @JoinColumn(name = "matricula_id")
    @JsonIgnore
    private Matricula matricula;

    public Laudo(Matricula matricula, LaudoRequest request) {
        this.matricula = matricula;
        this.dataEmissao =  request.getDataEmissao();
        this.validade = request.getDataEmissao().plusYears(1);
        this.renach = request.getRenach().toUpperCase();
    }

    public void altera(LaudoRequest request) {
        this.dataEmissao =  request.getDataEmissao();
        this.validade = request.getDataEmissao().plusYears(1);
        this.renach = request.getRenach().toUpperCase();
    }
}

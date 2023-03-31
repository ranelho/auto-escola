package com.rlti.autoescola.laudo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.matricula.domain.Matricula;
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
public class Laudo {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID idLaudo;
    private LocalDate dataEmissao;
    private LocalDate validade;    /* 1 ANO APÓS A DATA DE EMISSÃO */
    private String renach;         /* BA512150325 */

    @OneToOne
    @JoinColumn(name = "matricula_id")
    @JsonIgnore
    private Matricula matricula;
}

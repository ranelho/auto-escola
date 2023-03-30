package com.rlti.autoescola.servico.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.laudo.domain.Laudo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idServico;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private double valorServico;

    @OneToOne
    @JsonIgnore
    private Laudo laudo;
}

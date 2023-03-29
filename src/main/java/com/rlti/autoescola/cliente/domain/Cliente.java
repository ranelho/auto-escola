package com.rlti.autoescola.cliente.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.contato.domain.Contato;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
    @CPF
    private String cpf;
    @NotNull
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
    @JsonIgnore
    List<Contato> contato;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
    @JsonIgnore
    List<Matricula> matriculas;
}

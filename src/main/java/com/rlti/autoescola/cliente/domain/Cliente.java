package com.rlti.autoescola.cliente.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.cliente.domain.groups.ClienteGroupSequenceProvider;
import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.contato.domain.Contato;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@GroupSequenceProvider(value = ClienteGroupSequenceProvider.class)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
    @CPF(groups = PessoaFisica.class)
    @Column(unique = true)
    private String cpf;
    private String firstName;
    private String lastName;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa = TipoPessoa.FISICA;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
    @JsonIgnore
    List<Contato> contato;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
    @JsonIgnore
    List<Matricula> matriculas;

    public Cliente(ClienteRequest clienteRequest) {
        this.cpf = clienteRequest.getCpf();
        this.firstName = clienteRequest.getFirstName();
        this.lastName = clienteRequest.getLastName();
        this.dataNascimento = clienteRequest.getDataNascimento();
        this.naturalidade = clienteRequest.getNaturalidade();
        this.nacionalidade = clienteRequest.getNacionalidade();
        this.estadoCivil = clienteRequest.getEstadoCivil();
    }
}

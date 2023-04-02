package com.rlti.autoescola.cliente.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.cliente.domain.groups.ClienteGroupSequenceProvider;
import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.contato.domain.Contato;
import com.rlti.autoescola.matricula.domain.Matricula;
<<<<<<< HEAD
import lombok.*;
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
>>>>>>> c6942f576049c08c83150ecdfe01a27e538fd700
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
<<<<<<< HEAD
=======
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa = TipoPessoa.FISICA;
    @NotBlank(message = "Cpf Obrigatório!")
>>>>>>> c6942f576049c08c83150ecdfe01a27e538fd700
    @CPF(groups = PessoaFisica.class)
    @Column(unique = true)
    private String cpf;
    @NotNull(message = "Nome é Obrigatório!")
    private String firstName;
    private String lastName;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
<<<<<<< HEAD
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa = TipoPessoa.FISICA;
=======
>>>>>>> c6942f576049c08c83150ecdfe01a27e538fd700

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
    @JsonIgnore
    List<Contato> contato;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
    @JsonIgnore
    List<Matricula> matriculas;

    public Cliente(ClienteRequest clienteRequest) {
        this.tipoPessoa = getTipoPessoa();
        this.cpf = clienteRequest.getCpf();
        this.firstName = clienteRequest.getFirstName();
        this.lastName = clienteRequest.getLastName();
        this.dataNascimento = clienteRequest.getDataNascimento();
        this.naturalidade = clienteRequest.getNaturalidade();
        this.nacionalidade = clienteRequest.getNacionalidade();
<<<<<<< HEAD
        this.estadoCivil = clienteRequest.getEstadoCivil();
=======
>>>>>>> c6942f576049c08c83150ecdfe01a27e538fd700
    }
}

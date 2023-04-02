package com.rlti.autoescola.cliente.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.cliente.domain.groups.ClienteGroupSequenceProvider;
import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.contato.domain.Contato;
import com.rlti.autoescola.matricula.domain.Matricula;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@GroupSequenceProvider(value = ClienteGroupSequenceProvider.class)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa = TipoPessoa.FISICA;
    @NotBlank(message = "Cpf Obrigatório!")
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
    }
}

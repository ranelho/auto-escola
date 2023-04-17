package com.rlti.autoescola.cliente.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.cliente.application.api.EditaClienteRequest;
import com.rlti.autoescola.cliente.domain.groups.ClienteGroupSequenceProvider;
import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.contato.domain.Contato;
import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;
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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@GroupSequenceProvider(value = ClienteGroupSequenceProvider.class)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliente;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa = TipoPessoa.FISICA;
    @NotBlank(message = "Campo Obrigatório!")
    @CPF(groups = PessoaFisica.class, message = "CPF inválido!")
    @Column(unique = true)
    private String cpf;
    @NotNull(message = "Campo Obrigatório!")
    private String fullName;
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
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
    @JsonIgnore
    List<Exame> exames;

    public Cliente(ClienteRequest clienteRequest) {
        this.tipoPessoa = getTipoPessoa();
        this.cpf = clienteRequest.getCpf();
        this.fullName = clienteRequest.getFullName().toUpperCase();
        this.dataNascimento = clienteRequest.getDataNascimento();
        this.naturalidade = clienteRequest.getNaturalidade().toUpperCase();
        this.nacionalidade = clienteRequest.getNacionalidade().toUpperCase();
        this.estadoCivil = clienteRequest.getEstadoCivil();
    }
    public Cliente(OrcamentoRequest orcamentoRequest) {
        this.cpf = orcamentoRequest.getCpf();
        this.fullName = orcamentoRequest.getFullName().toUpperCase();
    }
    public void altera(EditaClienteRequest editaClienteRequest) {
        this.fullName = editaClienteRequest.getFirstName().toUpperCase();
        this.dataNascimento = editaClienteRequest.getDataNascimento();
        this.naturalidade = editaClienteRequest.getNaturalidade().toUpperCase();
        this.nacionalidade = editaClienteRequest.getNacionalidade().toUpperCase();
        this.estadoCivil = editaClienteRequest.getEstadoCivil();
    }
}
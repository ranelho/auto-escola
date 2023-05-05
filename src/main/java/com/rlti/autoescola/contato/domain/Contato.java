package com.rlti.autoescola.contato.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.application.api.ContatoRequest;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idContato;
    @Email
    private String email;
    private String telefone;
    private String cep;
    private String endereco;
    private String cidade;
    private String uf;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    public Contato(Cliente cliente, ContatoRequest contatoRequest) {
        this.email = contatoRequest.getEmail().toLowerCase();
        this.telefone = contatoRequest.getTelefone();
        this.cep = contatoRequest.getCep();
        this.endereco = contatoRequest.getEndereco().toUpperCase();
        this.cidade = contatoRequest.getCidade().toUpperCase();
        this.uf = contatoRequest.getUf().toUpperCase();
        this.cliente = cliente;
    }

    public Contato(Cliente cliente, OrcamentoRequest orcamentoRequest) {
        this.cliente = cliente;
        this.telefone = orcamentoRequest.getTelefone();
    }

    public void altera(ContatoRequest contatoRequest) {
        this.email = contatoRequest.getEmail().toLowerCase();
        this.telefone = contatoRequest.getTelefone();
        this.cep = contatoRequest.getCep();
        this.endereco = contatoRequest.getEndereco().toUpperCase();
        this.cidade = contatoRequest.getCidade().toUpperCase();
        this.uf = contatoRequest.getUf().toUpperCase();
        this.cliente = cliente;
    }
}

package com.rlti.autoescola.contato.application.api;

import com.rlti.autoescola.cliente.application.api.ClienteResponse;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.domain.Contato;
import lombok.Value;

import java.util.UUID;

@Value
public class ContatoResponse {
    Cliente cliente;
    UUID idContato;
    String telefone;
    String email;
    String cep;
    String endereco;
    String cidade;
    String uf;

    public ContatoResponse(Contato contato) {
        this.cliente = contato.getCliente();
        this.idContato = contato.getIdContato();
        this.telefone = contato.getTelefone();
        this.email = contato.getEmail();
        this.cep = contato.getCep();
        this.endereco = contato.getEndereco();
        this.cidade = contato.getCidade();
        this.uf = contato.getUf();
    }
}

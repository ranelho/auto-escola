package com.rlti.autoescola.contato.application.api;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.domain.Contato;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public static List<ContatoResponse> converte(List<Contato> contatos) {
        return contatos.stream()
                .map(ContatoResponse::new)
                .collect((Collectors.toList()));
    }
}
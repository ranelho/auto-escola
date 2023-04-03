package com.rlti.autoescola.contato.application.api;

import com.rlti.autoescola.cliente.domain.Cliente;
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
}

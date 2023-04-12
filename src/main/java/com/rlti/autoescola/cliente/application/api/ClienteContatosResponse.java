package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.application.api.ContatoListResponse;
import com.rlti.autoescola.contato.application.api.ContatoResponse;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Value
public class ClienteContatosResponse {
    UUID idCliente;
    String cpf;
    String fullName;
    LocalDate dataNascimento;
    List<ContatoListResponse> contatos;

    public ClienteContatosResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.cpf = cliente.getCpf();
        this.fullName = cliente.getFullName();
        this.dataNascimento = cliente.getDataNascimento();
        this.contatos = ContatoListResponse.converte(cliente.getContato());
    }
}
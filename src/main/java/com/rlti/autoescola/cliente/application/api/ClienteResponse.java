package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.domain.EstadoCivil;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class ClienteResponse {
    private final UUID idCliente;
    private final String cpf;
    private final String firstName;
    private final String lastName;
    private final LocalDate dataNascimento;
    private final String naturalidade;
    private final String nacionalidade;
    private final EstadoCivil estadoCivil;

    public ClienteResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.cpf = cliente.getCpf();
        this.firstName = cliente.getFirstName();
        this.lastName = cliente.getLastName();
        this.dataNascimento = cliente.getDataNascimento();
        this.naturalidade = cliente.getNaturalidade();
        this.nacionalidade = cliente.getNacionalidade();
        this.estadoCivil = cliente.getEstadoCivil();
    }
}

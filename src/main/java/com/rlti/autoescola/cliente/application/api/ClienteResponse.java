package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.domain.EstadoCivil;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class ClienteResponse {
    private UUID idCliente;
    private String cpf;
    private String firstName;
    private String lastName;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    private EstadoCivil estadoCivil;

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

package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.domain.enums.EstadoCivil;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ClienteResponse {
    UUID idCliente;
    String cpf;
    String fullName;
    LocalDate dataNascimento;
    String naturalidade;
    String nacionalidade;
    EstadoCivil estadoCivil;
    LocalDateTime createdAt;
    byte[] foto;

    public ClienteResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.cpf = cliente.getCpf();
        this.fullName = cliente.getFullName();
        this.dataNascimento = cliente.getDataNascimento();
        this.naturalidade = cliente.getNaturalidade();
        this.nacionalidade = cliente.getNacionalidade();
        this.estadoCivil = cliente.getEstadoCivil();
        this.createdAt = cliente.getCreatedAt();
        this.foto = cliente.getImagem().getFoto();
    }
}
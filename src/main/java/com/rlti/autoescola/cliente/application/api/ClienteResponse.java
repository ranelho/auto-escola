package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.domain.enums.EstadoCivil;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class ClienteResponse {
    UUID idCliente;
    String cpf;
    String fullName;
    LocalDate dataNascimento;
    String naturalidade;
    String nacionalidade;
    EstadoCivil estadoCivil;
   // byte[] imagem;

    public ClienteResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.cpf = cliente.getCpf();
        this.fullName = cliente.getFullName();
        this.dataNascimento = cliente.getDataNascimento();
        this.naturalidade = cliente.getNaturalidade();
        this.nacionalidade = cliente.getNacionalidade();
        this.estadoCivil = cliente.getEstadoCivil();
       // this.imagem = cliente.getImagem().getDados();
    }
}
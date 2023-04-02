package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.domain.EstadoCivil;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Value
public class ClienteRequest {
    @CPF
    private String cpf;
    private String firstName;
    private String lastName;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    private EstadoCivil estadoCivil;
}

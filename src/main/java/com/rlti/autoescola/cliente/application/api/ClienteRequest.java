package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.domain.EstadoCivil;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class ClienteRequest {
    @NotBlank(message = "Campo Obrigatório!")
    private String cpf;
    @NotNull(message = "Campo Obrigatório!")
    private String firstName;
    private String lastName;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    private EstadoCivil estadoCivil;
}
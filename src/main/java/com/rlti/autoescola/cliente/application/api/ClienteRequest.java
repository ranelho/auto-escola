package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.domain.EstadoCivil;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class ClienteRequest {
    @CPF
    private String cpf;
    @NotNull
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

}

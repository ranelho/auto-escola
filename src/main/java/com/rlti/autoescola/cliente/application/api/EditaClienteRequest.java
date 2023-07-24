package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.domain.enums.EstadoCivil;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EditaClienteRequest {
    @NotBlank(message = "Campo Obrigatório!")
    private String firstName;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    private EstadoCivil estadoCivil;
}

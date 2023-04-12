package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.domain.EstadoCivil;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class EditaClienteRequest {
    @NotNull(message = "Campo Obrigatório!")
    private String firstName;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    private EstadoCivil estadoCivil;
}

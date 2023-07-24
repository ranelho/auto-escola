package com.rlti.autoescola.empresa.application.api;

import lombok.Value;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

@Value
public class EmpresaUpdateRequest {
    @NotBlank
    String nomeFantasia;
    @NotBlank
    String nomeAdministrador;
    @NotBlank
    String areaAtuacao;
    @NotNull
    LocalDate dataAbertura;
    @NotBlank
    @Email
    String email;
    @Pattern(regexp = "^\\(\\d{2}\\)\\d{5}-\\d{4}$")
    String telefone;
    @NotNull
    String enderecoComercial;
}

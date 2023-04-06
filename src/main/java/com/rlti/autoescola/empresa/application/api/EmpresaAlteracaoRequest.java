package com.rlti.autoescola.empresa.application.api;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
@Value
public class EmpresaAlteracaoRequest {
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

package com.rlti.autoescola.empresa.application.api;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    String telefone;
    @NotNull
    String enderecoComercial;
}

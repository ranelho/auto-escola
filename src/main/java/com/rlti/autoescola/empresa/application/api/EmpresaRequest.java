package com.rlti.autoescola.empresa.application.api;

import lombok.Value;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Value
public class EmpresaRequest {
    @NotBlank String razaoSocial;
    @NotBlank
    String nomeFantasia;
    @NotBlank
    @Pattern(regexp = "(^\\d{2}\\x2E\\d{3}\\x2E\\d{3}/\\d{4}\\x2D\\d{2})$")
    String cnpj;
    @NotBlank
    String nomeAdministrador;
    @NotBlank
    String inscricaoMunicipal;
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
    @NotNull
    Boolean aceitaTermos;
}

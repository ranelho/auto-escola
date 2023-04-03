package com.rlti.autoescola.empresa.domain.application.api;

import lombok.Value;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class EmpresaRequest {

    UUID idEmpresa;
    @NotBlank
    String nomeCompletoEmpresa;
    @NotBlank
    String nomeAdministrador;
    @CNPJ
    String cnpj;
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

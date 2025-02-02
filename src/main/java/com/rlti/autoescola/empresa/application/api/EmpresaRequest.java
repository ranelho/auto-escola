package com.rlti.autoescola.empresa.application.api;

import com.rlti.autoescola.empresa.domain.groups.PessoaJuridica;
import lombok.Value;
import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

@Value
public class EmpresaRequest {
    @NotBlank String razaoSocial;
    @NotBlank
    String nomeFantasia;
    @NotBlank
    @Pattern(regexp = "(^\\d{2}\\x2E\\d{3}\\x2E\\d{3}/\\d{4}\\x2D\\d{2})$")
    @CNPJ(groups = PessoaJuridica.class, message = "CNPJ inválido!")
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
    @Pattern(regexp = "^\\(\\d{2}\\)\\d{5}-\\d{4}$")
    String telefone;
    @NotNull
    String enderecoComercial;
    @NotNull
    Boolean aceitaTermos;
}

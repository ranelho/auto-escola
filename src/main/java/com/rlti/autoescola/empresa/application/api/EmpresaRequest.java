package com.rlti.autoescola.empresa.application.api;

import com.rlti.autoescola.empresa.domain.TipoPessoa;
import lombok.Value;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class EmpresaRequest {
    @NotBlank String razaoSocial;
    @NotBlank
    String nomeFantasia;
    @NotBlank
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

package com.rlti.autoescola.empresa.domain.application.api;

import com.rlti.autoescola.cliente.domain.TipoPessoa;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class EmpresaRequest {

    @NotBlank
    String razaoSocial;
    @NotBlank
    String nomeFantasia;
    @NotNull(message = "Tipo pessoa é obrigatório")
    TipoPessoa tipoPessoa;
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

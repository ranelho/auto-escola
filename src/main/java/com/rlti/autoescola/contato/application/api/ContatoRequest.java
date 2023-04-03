package com.rlti.autoescola.contato.application.api;

import lombok.Value;

import javax.validation.constraints.Pattern;

@Value
public class ContatoRequest {
    @Pattern(regexp = "^\\(\\d{2}\\)\\d{4,5}\\-\\d{4}$", message = "Telefone inválido")
    String telefone;
    String cep;
    String endereco;
    String cidade;
    String uf;
}

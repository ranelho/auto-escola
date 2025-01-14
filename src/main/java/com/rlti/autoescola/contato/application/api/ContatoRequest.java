package com.rlti.autoescola.contato.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class ContatoRequest {
    @Pattern(regexp = "^\\(\\d{2}\\)\\d{4,5}\\-\\d{4}$", message = "Telefone inválido")
    String telefone;
    @Email
    String email;
    @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "CEP inválido")
    String cep;
    String endereco;
    String cidade;
    @Pattern(regexp = "^(AC|AL|AM|AP|BA|CE|DF|ES|GO|MA|MG|MS|MT|PA|PB|PE|PI|PR|RJ|RN|RO|RR|RS|SC|SE|SP|TO)$")
    String uf;
    Boolean padrao;
}

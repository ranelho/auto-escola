package com.rlti.autoescola.contato.application.api;

import com.rlti.autoescola.contato.domain.Contato;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class ContatoListResponse {
    String telefone;
    String email;
    String cep;
    String endereco;
    String cidade;
    String uf;

    public ContatoListResponse(Contato contato) {
        this.telefone = contato.getTelefone();
        this.email = contato.getEmail();
        this.cep = contato.getCep();
        this.endereco = contato.getEndereco();
        this.cidade = contato.getCidade();
        this.uf = contato.getUf();
    }
    public static List<ContatoListResponse> converte(List<Contato> contatos) {
        return contatos.stream()
                .map(ContatoListResponse::new)
                .collect((Collectors.toList()));
    }
}
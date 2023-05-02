package com.rlti.autoescola.contato.application;

import com.rlti.autoescola.contato.domain.Contato;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ContatoResumoResponse {
    String telefone;
    String email;
    String endereco;

    public ContatoResumoResponse(Contato contato) {
        this.telefone = contato.getTelefone();
        this.email = contato.getEmail();
        this.endereco =
                "CEP: " + contato.getCep() +
                ", ENDEREÇO: " + contato.getEndereco() +
                ", CIDADE: "   + contato.getCidade() + " - " + contato.getUf();
    }
    public static List<ContatoResumoResponse> converte(List<Contato> contatos) {
        return contatos.stream()
                .map(ContatoResumoResponse::new)
                .collect((Collectors.toList()));
    }
}

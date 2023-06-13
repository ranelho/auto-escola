package com.rlti.autoescola.contato.application.api;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.domain.Contato;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record ContatoResponse(
        UUID contato, Cliente cliente,
        UUID idContato,
        String telefone,
        String email,
        String cep,
        String endereco,
        String cidade,
        String uf)
{
    public ContatoResponse(Contato contato) {
        this(
                contato.getIdContato(),
                contato.getCliente(),
                contato.getIdContato(),
                contato.getTelefone(),
                contato.getEmail(),
                contato.getCep(),
                contato.getEndereco(),
                contato.getCidade(),
                contato.getUf()
        );
    }
    public static List<ContatoResponse> converte(List<Contato> contatos) {
        return contatos.stream()
                .map(ContatoResponse::new)
                .collect((Collectors.toList()));
    }
}
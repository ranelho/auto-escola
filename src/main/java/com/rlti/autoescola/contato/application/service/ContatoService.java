package com.rlti.autoescola.contato.application.service;

import com.rlti.autoescola.contato.application.api.ContatoRequest;
import com.rlti.autoescola.contato.application.api.ContatoResponse;

import java.util.List;
import java.util.UUID;

public interface ContatoService {
    ContatoResponse criaNovoContato(UUID idCliente, ContatoRequest contatoRequest);
    ContatoResponse buscaContatoPorId(UUID idContato);
    List<ContatoResponse> buscaContatosDoCliente(UUID idCliente);
    void deletaContatoPorId(UUID idContato);
    void editaContato(UUID idContato, ContatoRequest contatoRequest);
}

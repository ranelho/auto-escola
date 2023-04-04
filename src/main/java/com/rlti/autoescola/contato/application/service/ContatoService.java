package com.rlti.autoescola.contato.application.service;

import com.rlti.autoescola.contato.application.api.ContatoRequest;
import com.rlti.autoescola.contato.application.api.ContatoResponse;

import java.util.UUID;

public interface ContatoService {
    ContatoResponse criaNovoContato(UUID idCliente, ContatoRequest contatoRequest);
}

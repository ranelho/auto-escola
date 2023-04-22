package com.rlti.autoescola.contato.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteContatosResponse;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.application.api.ContatoRequest;
import com.rlti.autoescola.contato.application.api.ContatoResponse;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;

import java.util.UUID;

public interface ContatoService {
    ContatoResponse criaNovoContato(UUID idCliente, ContatoRequest contatoRequest);
    ContatoResponse findById(UUID idContato);
    ClienteContatosResponse buscaContatosDoCliente(UUID idCliente);
    void delete(UUID idContato);
    void update(UUID idContato, ContatoRequest contatoRequest);
    void verificaContato(Cliente cliente, OrcamentoRequest orcamentoRequest);
}

package com.rlti.autoescola.contato.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteContatosResponse;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.application.api.ContatoRequest;
import com.rlti.autoescola.contato.application.api.ContatoResponse;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;

import java.util.UUID;

public interface ContatoService {
    ContatoResponse saveContato(UUID idCliente, ContatoRequest contatoRequest);
    ContatoResponse getOneContato(UUID idContato);
    ClienteContatosResponse getAllContatosCliente(UUID idCliente);
    void deleteContato(UUID idContato);
    void updateContato(UUID idContato, ContatoRequest contatoRequest);
    void verificaContato(Cliente cliente, OrcamentoRequest orcamentoRequest);
}

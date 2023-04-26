package com.rlti.autoescola.contato.application.repository;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.domain.Contato;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContatoRepository {
    Contato saveContato(Contato contato);
    Contato findById(UUID idContato);
    List<Contato> buscaContatosDoCliente(Cliente cliente);
    void deleteContato(UUID idContato);
    Optional<Contato> findTelefoneContato(String telefone);
}

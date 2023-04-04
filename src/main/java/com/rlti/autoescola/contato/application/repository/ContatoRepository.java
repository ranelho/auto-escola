package com.rlti.autoescola.contato.application.repository;

import com.rlti.autoescola.contato.domain.Contato;

import java.util.UUID;

public interface ContatoRepository {
    Contato salvaContato(Contato contato);
    Contato buscaContatoPorId(UUID idContato);
}

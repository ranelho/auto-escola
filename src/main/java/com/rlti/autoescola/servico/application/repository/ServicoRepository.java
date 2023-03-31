package com.rlti.autoescola.servico.application.repository;

import com.rlti.autoescola.servico.domain.Servico;

import java.util.UUID;

public interface ServicoRepository {
    Servico salva(Servico servico);
    Servico getById(UUID idServico);
}
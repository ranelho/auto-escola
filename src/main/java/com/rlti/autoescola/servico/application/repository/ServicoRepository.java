package com.rlti.autoescola.servico.application.repository;

import com.rlti.autoescola.servico.domain.Servico;

import java.util.List;
import java.util.UUID;

public interface ServicoRepository {
    Servico salva(Servico servico);
    Servico getOneServico(UUID idServico);
    List<Servico> getAllServicos();
    void deleteServico(UUID idServico);
}
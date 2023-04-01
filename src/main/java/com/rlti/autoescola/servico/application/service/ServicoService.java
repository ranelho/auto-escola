package com.rlti.autoescola.servico.application.service;

import com.rlti.autoescola.servico.application.api.ServicoIdResponse;
import com.rlti.autoescola.servico.application.api.ServicoRequest;
import com.rlti.autoescola.servico.domain.Servico;

import java.util.List;
import java.util.UUID;

public interface ServicoService {
    ServicoIdResponse saveFrota(ServicoRequest request);
    Servico getById(UUID idServico);
    List<Servico> getAll();
}
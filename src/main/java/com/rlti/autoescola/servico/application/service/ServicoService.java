package com.rlti.autoescola.servico.application.service;

import com.rlti.autoescola.servico.application.api.ServicoIdResponse;
import com.rlti.autoescola.servico.application.api.ServicoRequest;
import com.rlti.autoescola.servico.application.api.ServicoUpdateRequest;
import com.rlti.autoescola.servico.domain.Servico;

import java.util.List;
import java.util.UUID;

public interface ServicoService {
    ServicoIdResponse post(ServicoRequest request);
    Servico getById(UUID idServico);
    List<Servico> getAll();
    void delete(UUID idServico);
    void update(UUID idServico, ServicoUpdateRequest updateRequest);
}
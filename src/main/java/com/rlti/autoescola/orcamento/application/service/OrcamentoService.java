package com.rlti.autoescola.orcamento.application.service;

import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;
import com.rlti.autoescola.orcamento.application.api.OrcamentoResponse;

public interface OrcamentoService {
    OrcamentoResponse criaNovoOrcamento(OrcamentoRequest orcamentoRequest);
    OrcamentoResponse getById(Long idOrcamento);
}
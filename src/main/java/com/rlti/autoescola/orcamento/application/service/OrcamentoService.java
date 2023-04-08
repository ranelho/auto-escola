package com.rlti.autoescola.orcamento.application.service;

import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;
import com.rlti.autoescola.orcamento.application.api.OrcamentoResponse;

import java.util.UUID;

public interface OrcamentoService {
    OrcamentoResponse criaNovoOrcamento(UUID idCliente, UUID idServico, OrcamentoRequest orcamentoRequest);
}

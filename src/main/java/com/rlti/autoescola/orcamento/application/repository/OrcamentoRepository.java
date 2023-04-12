package com.rlti.autoescola.orcamento.application.repository;

import com.rlti.autoescola.orcamento.domain.Orcamento;

public interface OrcamentoRepository {
    Orcamento salvaOrcamento(Orcamento orcamento);
    Orcamento getOrcamentoById(Long idOrcamento);
    void deleteOrcamentoExpirado();
}

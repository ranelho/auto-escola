package com.rlti.autoescola.orcamento.application.repository;

import com.rlti.autoescola.orcamento.domain.Orcamento;

public interface OrcamentoRepository {
    Orcamento saveOrcamento(Orcamento orcamento);
    Orcamento getOneOrcamento(Long idOrcamento);
    void deleteOrcamentoExpirado();
    void deleteOrcamento(Long idOrcamento);
    Orcamento getOneOrcamentoByCpf(String cpf);
}

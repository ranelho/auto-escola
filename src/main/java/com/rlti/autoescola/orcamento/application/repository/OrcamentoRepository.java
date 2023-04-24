package com.rlti.autoescola.orcamento.application.repository;

import com.rlti.autoescola.orcamento.domain.Orcamento;

public interface OrcamentoRepository {
    Orcamento salvaOrcamento(Orcamento orcamento);
    Orcamento getById(Long idOrcamento);
    void deleteOrcamentoExpirado();
    void deleteById(Long idOrcamento);
    Orcamento findByCpf(String cpf);
}

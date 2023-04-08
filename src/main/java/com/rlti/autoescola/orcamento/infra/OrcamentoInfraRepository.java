package com.rlti.autoescola.orcamento.infra;

import com.rlti.autoescola.orcamento.application.repository.OrcamentoRepository;
import com.rlti.autoescola.orcamento.domain.Orcamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class OrcamentoInfraRepository implements OrcamentoRepository {
    private final OrcamentoSpringDataJPARepository orcamentoSpringDataJPARepository;

    @Override
    public Orcamento salvaOrcamento(Orcamento orcamento) {
        log.info("[inicia] OrcamentoInfraRepository - salvaOrcamento");
        Orcamento orcamentoCriado = orcamentoSpringDataJPARepository.save(orcamento);
        log.info("[finaliza] OrcamentoInfraRepository - salvaOrcamento");
        return orcamentoCriado;
    }
}

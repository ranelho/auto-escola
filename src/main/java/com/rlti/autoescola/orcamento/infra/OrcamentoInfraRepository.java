package com.rlti.autoescola.orcamento.infra;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.orcamento.application.repository.OrcamentoRepository;
import com.rlti.autoescola.orcamento.domain.Orcamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

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
    @Override
    public Orcamento getOrcamentoById(Long idOrcamento) {
        log.info("[inicia] OrcamentoInfraRepository - getOrcamentoById");
        Optional<Orcamento> optionalOrcamento = orcamentoSpringDataJPARepository.findById(idOrcamento);
        Orcamento orcamento = optionalOrcamento
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                                "Orçamento não encontrado!"));
        log.info("[finaliza] OrcamentoInfraRepository - getOrcamentoById");
        return (orcamento);
    }

    @Scheduled(fixedRate = 86400000) // Executa a cada 24 horas)
    @Override
    @Transactional
    public void deleteOrcamentoExpirado() {
        log.info("[inicia] OrcamentoInfraRepository - deleteOrcamentoExpirado");
        orcamentoSpringDataJPARepository.deleteOrcamentoExpirado(LocalDate.now());
        log.info("[finaliza] OrcamentoInfraRepository - deleteOrcamentoExpirado");
    }
}

package com.rlti.autoescola.orcamento.infra;

import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.orcamento.application.repository.OrcamentoRepository;
import com.rlti.autoescola.orcamento.domain.Orcamento;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Log4j2
public class OrcamentoInfraRepository implements OrcamentoRepository {
    private final OrcamentoSpringDataJPARepository orcamentoSpringDataJPARepository;

    @Override
    public Orcamento saveOrcamento(Orcamento orcamento) {
        log.info("[inicia] OrcamentoInfraRepository - saveOrcamento");
        Orcamento orcamentoCriado = orcamentoSpringDataJPARepository.save(orcamento);
        log.info("[finaliza] OrcamentoInfraRepository - saveOrcamento");
        return orcamentoCriado;
    }
    @Override
    public Orcamento getOneOrcamento(Long idOrcamento) {
        log.info("[inicia] OrcamentoInfraRepository - getOneOrcamento");
        Optional<Orcamento> optionalOrcamento = orcamentoSpringDataJPARepository.findById(idOrcamento);
        Orcamento orcamento = optionalOrcamento
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                                "Orçamento não encontrado!"));
        log.info("[finaliza] OrcamentoInfraRepository - getOneOrcamento");
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

    @Override
    public void deleteOrcamento(Long idOrcamento) {
        log.info("[inicia] OrcamentoInfraRepository - deleteOrcamento");
        orcamentoSpringDataJPARepository.deleteById(idOrcamento);
        log.info("[finaliza] OrcamentoInfraRepository - deleteOrcamento");
    }

    @Override
    public Orcamento getOneOrcamentoByCpf(String cpf) {
        log.info("[inicia] OrcamentoInfraRepository - getOneOrcamentoByCpf");
        Optional<Orcamento> optionalOrcamento = orcamentoSpringDataJPARepository.findByClienteCpf(cpf);
        Orcamento orcamento = optionalOrcamento
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,
                        "Orçamento não encontrado!"));
        log.info("[finaliza] OrcamentoInfraRepository - getOneOrcamentoByCpf");
        return orcamento;
    }
}

package com.rlti.autoescola.servico.infra;

import com.rlti.autoescola.servico.application.repository.ServicoRepository;
import com.rlti.autoescola.servico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ServicoInfraRepository implements ServicoRepository {
    private final ServicoSpringDataInfraRepository servicoSpringDataInfraRepository;

    @Override
    public Servico salva(Servico servico) {
        log.info("[inicia] ServicoInfraRepository - salva");
        servicoSpringDataInfraRepository.save(servico);
        log.info("[finaliza] ServicoInfraRepository - salva");
        return servico;
    }
}

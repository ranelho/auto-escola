package com.rlti.autoescola.exame.infra;

import com.rlti.autoescola.exame.application.repository.ExameRepository;
import com.rlti.autoescola.exame.domain.Exame;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ExameInfraRepository implements ExameRepository {
    private final ExameSpringDataJPARepository exameSpringDataJPARepository;

    @Override
    public Exame salva(Exame exame) {
        log.info("[inicia] ExameInfraRepository -  salva");
        exameSpringDataJPARepository.save(exame);
        log.info("[finaliza] ExameInfraRepository -  salva");
        return exame;
    }
}

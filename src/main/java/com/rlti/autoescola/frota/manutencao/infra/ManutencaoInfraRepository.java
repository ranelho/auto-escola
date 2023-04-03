package com.rlti.autoescola.frota.manutencao.infra;

import com.rlti.autoescola.frota.manutencao.application.repository.ManutencaoRepository;
import com.rlti.autoescola.frota.manutencao.Manutencao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ManutencaoInfraRepository implements ManutencaoRepository {
    private final ManutencaoSpringDataJPARepository manutencaoSpringDataJPARepository;
    @Override
    public Manutencao salva(Manutencao manutencao) {
        log.info("[inicia] ManutencaoInfraRepository - salva");
        manutencaoSpringDataJPARepository.save(manutencao);
        log.info("[finaliza] ManutencaoInfraRepository - salva");
        return manutencao;
    }
}

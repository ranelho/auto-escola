package com.rlti.autoescola.exame.infra;

import com.rlti.autoescola.exame.application.repository.ExameRepository;
import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

    @Override
    public Exame buscaExamePorId(Long idExame) {
        log.info("[inicia] ExameInfraRepository -  buscaExamePorId");
        Optional<Exame> optionalExame = exameSpringDataJPARepository.findById(idExame);
        Exame exame = optionalExame
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "Exame não encontrado"));
        return exame;
    }
}

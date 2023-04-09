package com.rlti.autoescola.instrutor.application.service;

import com.rlti.autoescola.instrutor.application.api.InstrutorIdResponse;
import com.rlti.autoescola.instrutor.application.api.InstrutorResponse;
import com.rlti.autoescola.instrutor.application.api.InstrutorResquest;
import com.rlti.autoescola.instrutor.application.api.InstrutorUpdateResquest;
import com.rlti.autoescola.instrutor.application.repository.InstrutorRepository;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class InstrutorApplicationService implements InstrutorService {
    private final InstrutorRepository instrutorRepository;

    @Override
    public InstrutorIdResponse post(InstrutorResquest resquest) {
        log.info("[inicia] InstrutorApplicationService - post");
        Instrutor instrutor = instrutorRepository.save(new Instrutor(resquest));
        log.info("[finaliza] InstrutorApplicationService - post");
        return InstrutorIdResponse.builder().idInstrutor(instrutor.getIdInstrutor()).build();
    }

    @Override
    public InstrutorResponse getInstrutor(UUID idInstrutor) {
        log.info("[inicia] InstrutorApplicationService - getInstrutor");
        Instrutor instrutor = instrutorRepository.getInstrutor(idInstrutor);
        log.info("[finaliza] InstrutorApplicationService - getInstrutor");
        return new InstrutorResponse(instrutor);
    }

    @Override
    public void update(UUID idInstrutor, InstrutorUpdateResquest updateRequest) {
        log.info("[inicia] InstrutorApplicationService - update");
        Instrutor instrutor = instrutorRepository.getInstrutor(idInstrutor);
        instrutor.update(updateRequest);
        instrutorRepository.save(instrutor);
        log.info("[finaliza] InstrutorApplicationService - update");
    }
}

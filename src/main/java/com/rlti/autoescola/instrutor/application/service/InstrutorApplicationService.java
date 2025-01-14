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

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class InstrutorApplicationService implements InstrutorService {
    private final InstrutorRepository instrutorRepository;

    @Override
    public InstrutorIdResponse saveInstrutor(InstrutorResquest resquest) {
        log.info("[inicia] InstrutorApplicationService - post");
        Instrutor instrutor = instrutorRepository.saveInstrutor(new Instrutor(resquest));
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
        instrutor.altera(updateRequest);
        instrutorRepository.saveInstrutor(instrutor);
        log.info("[finaliza] InstrutorApplicationService - update");
    }

    @Override
    public List<InstrutorResponse> getAllInstrutors() {
        log.info("[inicia] InstrutorApplicationService - getAllInstrutors");
        List<Instrutor> instrutors = instrutorRepository.getAllInstrutors();
        log.info("[finaliza] InstrutorApplicationService - getAllInstrutors");
        return InstrutorResponse.converte(instrutors);
    }

    @Override
    public void inativaInstrutor(UUID idInstrutor) {
        log.info("[inicia] InstrutorApplicationService - getAllInstrutors");
        Instrutor instrutor = instrutorRepository.getInstrutor(idInstrutor);
        instrutor.inativa();
        instrutorRepository.saveInstrutor(instrutor);
        log.info("[finaliza] InstrutorApplicationService - getAllInstrutors");
    }
}
package com.rlti.autoescola.laudo.application.service;

import com.rlti.autoescola.laudo.application.api.LaudoIdResponse;
import com.rlti.autoescola.laudo.application.api.LaudoRequest;
import com.rlti.autoescola.laudo.application.api.LaudoResponse;
import com.rlti.autoescola.laudo.application.repository.LaudoRepository;
import com.rlti.autoescola.laudo.domain.Laudo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class LaudoApplicationService implements LaudoService {
    private final LaudoRepository laudoRepository;

    @Override
    public LaudoIdResponse postLaudo(UUID idMatricula, LaudoRequest request) {
        log.info("[inicia] LaudoApplicationService -  postLaudo");
        Laudo laudo = laudoRepository.salva(new Laudo(request));
        log.info("[finaliza] LaudoApplicationService -  postLaudo");
        return LaudoIdResponse.builder().idLaudo(laudo.getIdLaudo()).build();
    }

    @Override
    public LaudoResponse getLaudoByMatricula(UUID idMatricula) {
        log.info("[inicia] LaudoApplicationService -  getLaudoByMatricula");
        log.info("[finaliza] LaudoApplicationService -  getLaudoByMatricula");
        return null;
    }
}
package com.rlti.autoescola.laudo.application.api;

import com.rlti.autoescola.laudo.application.service.LaudoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Log4j2
public class LaudoRestController implements LaudoApi {
    private final LaudoService laudoService;

    @Override
    public LaudoIdResponse post(UUID idMatricula, LaudoRequest request) {
        log.info("[inicia] - LaudoRestController - post");
        LaudoIdResponse idResponse = laudoService.post(idMatricula, request);
        log.info("[finaliza] - LaudoRestController - post");
        return idResponse;
    }

    @Override
    public LaudoResponse getById(Long idLaudo) {
        log.info("[inicia] - LaudoRestController - post");
        LaudoResponse response = laudoService.getById(idLaudo);
        log.info("[finaliza] - LaudoRestController - post");
        return response;
    }

    @Override
    public void update(Long idLaudo,LaudoRequest request) {
        log.info("[inicia] - LaudoRestController - post");
        laudoService.update(idLaudo, request);
        log.info("[finaliza] - LaudoRestController - post");
    }

    @Override
    public void delete(Long idLaudo) {
        log.info("[inicia] - LaudoRestController - post");
        laudoService.delete(idLaudo);
        log.info("[finaliza] - LaudoRestController - post");
    }

    @Override
    public List<LaudoResponse> getByMatricula(UUID idMatricula) {
        log.info("[inicia] - LaudoRestController - getById");
        List<LaudoResponse> laudoResponseMatricula = laudoService.getByMatricula(idMatricula);
        log.info("[finaliza] - LaudoRestController - getById");
        return laudoResponseMatricula;
    }
}

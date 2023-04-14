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
    public LaudoIdResponse postLaudo(UUID idMatricula, LaudoRequest request) {
        log.info("[inicia] - LaudoRestController - postLaudo");
        LaudoIdResponse idResponse = laudoService.postLaudo(idMatricula, request);
        log.info("[finaliza] - LaudoRestController - postLaudo");
        return idResponse;
    }

    @Override
    public LaudoResponse getLaudoById(Long idLaudo) {
        log.info("[inicia] - LaudoRestController - postLaudo");
        LaudoResponse response = laudoService.getLaudoById(idLaudo);
        log.info("[finaliza] - LaudoRestController - postLaudo");
        return response;
    }

    @Override
    public void update(Long idLaudo,LaudoRequest request) {
        log.info("[inicia] - LaudoRestController - postLaudo");
        laudoService.update(idLaudo, request);
        log.info("[finaliza] - LaudoRestController - postLaudo");
    }

    @Override
    public void deleta(Long idLaudo) {
        log.info("[inicia] - LaudoRestController - postLaudo");
        laudoService.deleta(idLaudo);
        log.info("[finaliza] - LaudoRestController - postLaudo");
    }

    @Override
    public List<LaudoResponse> getLaudoByMatricula(UUID idMatricula) {
        log.info("[inicia] - LaudoRestController - getLaudoById");
        List<LaudoResponse> laudoResponseMatricula = laudoService.getLaudoByMatricula(idMatricula);
        log.info("[finaliza] - LaudoRestController - getLaudoById");
        return laudoResponseMatricula;
    }
}

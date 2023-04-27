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
    public LaudoIdResponse saveLaudo(UUID idMatricula, LaudoRequest request) {
        log.info("[inicia] - LaudoRestController - saveLaudo");
        LaudoIdResponse idResponse = laudoService.saveLaudo(idMatricula, request);
        log.info("[finaliza] - LaudoRestController - saveLaudo");
        return idResponse;
    }

    @Override
    public LaudoResponse getOneLaudo(Long idLaudo) {
        log.info("[inicia] - LaudoRestController - getOneLaudo");
        LaudoResponse response = laudoService.getOneLaudo(idLaudo);
        log.info("[finaliza] - LaudoRestController - getOneLaudo");
        return response;
    }

    @Override
    public void updateLaudo(Long idLaudo, LaudoRequest request) {
        log.info("[inicia] - LaudoRestController - updateLaudo");
        laudoService.updateLaudo(idLaudo, request);
        log.info("[finaliza] - LaudoRestController - updateLaudo");
    }

    @Override
    public void deleteLaudo(Long idLaudo) {
        log.info("[inicia] - LaudoRestController - deleteLaudo");
        laudoService.deleteLaudo(idLaudo);
        log.info("[finaliza] - LaudoRestController - deleteLaudo");
    }

    @Override
    public List<LaudoResponse> getAllLaudosByMatricula(UUID idMatricula) {
        log.info("[inicia] - LaudoRestController - getAllLaudosByMatricula");
        List<LaudoResponse> laudoResponseMatricula = laudoService.getAllLaudosByMatricula(idMatricula);
        log.info("[finaliza] - LaudoRestController - getAllLaudosByMatricula");
        return laudoResponseMatricula;
    }
}

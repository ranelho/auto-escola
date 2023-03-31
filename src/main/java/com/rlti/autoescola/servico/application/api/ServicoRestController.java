package com.rlti.autoescola.servico.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ServicoRestController implements ServicoApi {
    @Override
    public ServicoIdResponse saveFrota(ServicoRequest request) {
        log.info("[inicia] ServicoRestController - saveFrota");
        log.info("[finaliza] ServicoRestController - saveFrota");
        return null;
    }
}

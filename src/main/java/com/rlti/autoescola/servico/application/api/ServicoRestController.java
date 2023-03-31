package com.rlti.autoescola.servico.application.api;

import com.rlti.autoescola.servico.application.service.ServicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ServicoRestController implements ServicoApi {
    private final ServicoService servicoService;

    @Override
    public ServicoIdResponse saveFrota(ServicoRequest request) {
        log.info("[inicia] ServicoRestController - saveFrota");
        ServicoIdResponse idResponse = servicoService.saveFrota(request);
        log.info("[finaliza] ServicoRestController - saveFrota");
        return null;
    }
}

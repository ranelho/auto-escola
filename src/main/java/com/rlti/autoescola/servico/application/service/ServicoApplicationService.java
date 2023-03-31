package com.rlti.autoescola.servico.application.service;

import com.rlti.autoescola.servico.application.api.ServicoIdResponse;
import com.rlti.autoescola.servico.application.api.ServicoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ServicoApplicationService implements ServicoService {
    @Override
    public ServicoIdResponse saveFrota(ServicoRequest request) {
        log.info("[inicia] ServicoApplicationService - saveFrota");
        log.info("[finaliza] ServicoApplicationService - saveFrota");
        return null;
    }
}

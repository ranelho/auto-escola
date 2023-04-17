package com.rlti.autoescola.exame.application.api;

import com.rlti.autoescola.exame.application.service.ExameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ExameRestController implements ExameApi {
    private final ExameService exameService;

    @Override
    public ExameIdResponse cadastrar(UUID idCliente, ExameRequest request) {
        log.info("[inicia] ExameRestController - cadastrar");
        ExameIdResponse idResponse = exameService.cadastrar(idCliente, request);
        log.info("[finaliza] ExameRestController - cadastrar");
        return idResponse;
    }
}

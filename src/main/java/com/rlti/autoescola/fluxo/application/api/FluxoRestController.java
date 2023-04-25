package com.rlti.autoescola.fluxo.application.api;

import com.rlti.autoescola.fluxo.application.service.FluxoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@Log4j2
public class FluxoRestController implements FluxoApi {
    private final FluxoService fluxoService;

    @Override
    public FluxoDeCaixaResponse getFluxoDiario(LocalDate data) {
        log.info("[inicia] FluxoRestController - getFluxoDeCaixa");
        FluxoDeCaixaResponse response = fluxoService.getFluxoDiario(data);
        log.info("[finaliza] FluxoRestController - getFluxoDeCaixa");
        return response;
    }
}

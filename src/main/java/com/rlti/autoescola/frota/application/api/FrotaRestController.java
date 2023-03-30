package com.rlti.autoescola.frota.application.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class FrotaRestController implements FrotaApi {
    @Override
    public VeiculoIdResponse saveFrota(VeiculoRequest request) {
        log.info("[inicia] FrotaRestController - saveFrota");
        log.info("[finaliza] FrotaRestController - saveFrota");
        return null;
    }
}

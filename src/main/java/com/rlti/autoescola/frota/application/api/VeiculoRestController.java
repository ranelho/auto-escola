package com.rlti.autoescola.frota.application.api;

import com.rlti.autoescola.frota.application.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class VeiculoRestController implements VeiculoApi {
    private final VeiculoService veiculoService;

    @Override
    public VeiculoIdResponse saveFrota(VeiculoRequest request) {
        log.info("[inicia] FrotaRestController - saveFrota");
        VeiculoIdResponse idResponse = veiculoService.saveVeiculo(request);
        log.info("[finaliza] FrotaRestController - saveFrota");
        return idResponse;
    }
}

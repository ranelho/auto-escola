package com.rlti.autoescola.frota.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class VeiculoApplicationService implements VeiculoService {

    @Override
    public VeiculoIdResponse saveVeiculo(VeiculoRequest request) {
        log.info("[inicia] VeiculoApplicationService - saveVeiculo");
        log.info("[finaliza] VeiculoApplicationService - saveVeiculo");
        return null;
    }
}

package com.rlti.autoescola.frota.manutencao.application.api;

import com.rlti.autoescola.frota.manutencao.application.service.ManutencaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ManutencaoRestController implements ManutencaoApi {
    private final ManutencaoService manutencaoService;

    @Override
    public ManutencaoIdResponse novaManutencao(String placa, ManutencaoRequest request) {
        log.info("[inicia] ManutencaoRestController - novaManutencao");
        ManutencaoIdResponse idResponse = manutencaoService.novaManutencao(placa,request);
        log.info("[finaliza] ManutencaoRestController - novaManutencao");
        return idResponse;
    }

    @Override
    public VeiculoManutencaoResponse getManutencoesVeiculo(String placa) {
        log.info("[inicia] ManutencaoRestController - novaManutencao");
        VeiculoManutencaoResponse response = manutencaoService.getManutencoesVeiculo(placa);
        log.info("[finaliza] ManutencaoRestController - novaManutencao");
        return response;
    }
}

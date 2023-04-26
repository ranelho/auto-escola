package com.rlti.autoescola.frota.manutencao.application.api;

import com.rlti.autoescola.frota.manutencao.application.service.ManutencaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ManutencaoRestController implements ManutencaoApi {
    private final ManutencaoService manutencaoService;

    @Override
    public ManutencaoIdResponse saveManutencao(String placa, ManutencaoRequest request) {
        log.info("[inicia] ManutencaoRestController - post");
        ManutencaoIdResponse idResponse = manutencaoService.saveManutencao(placa,request);
        log.info("[finaliza] ManutencaoRestController - post");
        return idResponse;
    }

    @Override
    public VeiculoManutencaoResponse getByVeiculo(String placa) {
        log.info("[inicia] ManutencaoRestController - getByVeiculo");
        VeiculoManutencaoResponse response = manutencaoService.getByVeiculo(placa);
        log.info("[finaliza] ManutencaoRestController - getByVeiculo");
        return response;
    }

    @Override
    public List<ManutencaoListResponse> getManutencaoByVeiculo(String placa) {
        log.info("[inicia] ManutencaoRestController - getByVeiculoVeiculo");
        List<ManutencaoListResponse> listResponses = manutencaoService.getManutencaoByVeiculo(placa);
        log.info("[finaliza] ManutencaoRestController - getByVeiculoVeiculo");
        return listResponses;
    }

    @Override
    public ManutencaoResponse getOneManutencao(Long idManutencao) {
        log.info("[inicia] ManutencaoRestController - getById");
        ManutencaoResponse response = manutencaoService.getOneManutencao(idManutencao);
        log.info("[finaliza] ManutencaoRestController - getById");
        return response;
    }

    @Override
    public void updateManutencao(Long idManutencao, ManutencaoRequest request) {
        log.info("[inicia] ManutencaoRestController - getById");
        manutencaoService.updateManutencao(idManutencao, request);
        log.info("[finaliza] ManutencaoRestController - getById");
    }

    @Override
    public void deleteManutencao(Long idManutencao) {
        log.info("[inicia] ManutencaoRestController - delete");
        manutencaoService.deleteManutencao(idManutencao);
        log.info("[finaliza] ManutencaoRestController - delete");
    }
}

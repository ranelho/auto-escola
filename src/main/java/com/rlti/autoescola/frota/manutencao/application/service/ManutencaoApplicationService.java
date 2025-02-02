package com.rlti.autoescola.frota.manutencao.application.service;

import com.rlti.autoescola.frota.manutencao.application.api.*;
import com.rlti.autoescola.frota.manutencao.application.repository.ManutencaoRepository;
import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.frota.veiculo.application.repository.VeiculoRepository;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ManutencaoApplicationService implements ManutencaoService {
    private final ManutencaoRepository manutencaoRepository;
    private final VeiculoRepository veiculoRepository;

    @Override
    public ManutencaoIdResponse saveManutencao(String placa, ManutencaoRequest request) {
        log.info("[inicia] ManutencaoApplicationService - saveManutencao");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        Manutencao manutencao = manutencaoRepository.saveManutencao(new Manutencao(veiculo, request));
        log.info("[finaliza] ManutencaoApplicationService - saveManutencao");
        return ManutencaoIdResponse.builder().idManutencao(manutencao.getIdManutencao()).build();
    }

    @Override
    public VeiculoManutencaoResponse getByVeiculo(String placa) {
        log.info("[inicia] ManutencaoApplicationService - getByVeiculo");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        log.info("[finaliza] ManutencaoApplicationService - getByVeiculo");
        return new VeiculoManutencaoResponse(veiculo);
    }

    @Override
    public List<ManutencaoListResponse> getManutencaoByVeiculo(String placa) {
        log.info("[inicia] ManutencaoApplicationService - getManutencaoByVeiculo");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        List<Manutencao> manutencoes = manutencaoRepository.getAllManutencoes(veiculo);
        log.info("[finaliza] ManutencaoApplicationService - getManutencaoByVeiculo");
        return ManutencaoListResponse.converte(manutencoes);

    }

    @Override
    public ManutencaoResponse getOneManutencao(Long idManutencao) {
        log.info("[inicia] ManutencaoApplicationService - getById");
        Manutencao manutencao = manutencaoRepository.getOneManutencao(idManutencao);
        log.info("[finaliza] ManutencaoApplicationService - getById");
        return new ManutencaoResponse(manutencao);
    }

    @Override
    public void updateManutencao(Long idManutencao, ManutencaoRequest request) {
        log.info("[inicia] ManutencaoApplicationService - update");
        Manutencao manutencao = manutencaoRepository.getOneManutencao(idManutencao);
        manutencao.altera(request);
        manutencaoRepository.saveManutencao(manutencao);
        log.info("[finaliza] ManutencaoApplicationService - update");
    }

    @Override
    public void deleteManutencao(Long idManutencao) {
        log.info("[inicia] ManutencaoApplicationService - delete");
        manutencaoRepository.deleteManutencao(manutencaoRepository.getOneManutencao(idManutencao).getIdManutencao());
        log.info("[finaliza] ManutencaoApplicationService - delete");
    }
}
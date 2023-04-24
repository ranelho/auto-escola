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
    private final VeiculoRepository veiculoRepository;
    private final ManutencaoRepository manutencaoRepository;

    @Override
    public ManutencaoIdResponse post(String placa, ManutencaoRequest request) {
        log.info("[inicia] ManutencaoApplicationService - post");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        Manutencao manutencao = manutencaoRepository.salva(new Manutencao(veiculo, request));
        log.info("[finaliza] ManutencaoApplicationService - post");
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
    public List<ManutencaoListResponse> getByVeiculoVeiculo(String placa) {
        log.info("[inicia] ManutencaoApplicationService - getByVeiculoVeiculo");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        List<Manutencao> manutencoes = manutencaoRepository.findAll(veiculo);
        log.info("[finaliza] ManutencaoApplicationService - getByVeiculoVeiculo");
        return ManutencaoListResponse.converte(manutencoes);

    }

    @Override
    public ManutencaoResponse getById(Long idManutencao) {
        log.info("[inicia] ManutencaoApplicationService - getById");
        Manutencao manutencao = manutencaoRepository.getById(idManutencao);
        log.info("[finaliza] ManutencaoApplicationService - getById");
        return new ManutencaoResponse(manutencao);
    }

    @Override
    public void update(Long idManutencao, ManutencaoRequest request) {
        log.info("[inicia] ManutencaoApplicationService - update");
        Manutencao manutencao = manutencaoRepository.getById(idManutencao);
        manutencao.altera(request);
        manutencaoRepository.salva(manutencao);
        log.info("[finaliza] ManutencaoApplicationService - update");
    }

    @Override
    public void delete(Long idManutencao) {
        log.info("[inicia] ManutencaoApplicationService - delete");
        manutencaoRepository.delete(manutencaoRepository.getById(idManutencao).getIdManutencao());
        log.info("[finaliza] ManutencaoApplicationService - delete");
    }
}
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
    public ManutencaoIdResponse novaManutencao(String placa, ManutencaoRequest request) {
        log.info("[inicia] ManutencaoApplicationService - novaManutencao");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        Manutencao manutencao = manutencaoRepository.salva(new Manutencao(veiculo, request));
        log.info("[finaliza] ManutencaoApplicationService - novaManutencao");
        return ManutencaoIdResponse.builder().idManutencao(manutencao.getIdManutencao()).build();
    }

    @Override
    public VeiculoManutencaoResponse buscaManutencoes(String placa) {
        log.info("[inicia] ManutencaoApplicationService - buscaManutencoes");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        log.info("[finaliza] ManutencaoApplicationService - buscaManutencoes");
        return new VeiculoManutencaoResponse(veiculo);
    }

    @Override
    public List<ManutencaoListResponse> buscaManutencoesVeiculo(String placa) {
        log.info("[inicia] ManutencaoApplicationService - buscaManutencoesVeiculo");
        Veiculo veiculo = veiculoRepository.getByPlaca(placa);
        List<Manutencao> manutencoes = manutencaoRepository.findAll(veiculo);
        log.info("[finaliza] ManutencaoApplicationService - buscaManutencoesVeiculo");
        return ManutencaoListResponse.converte(manutencoes);

    }

    @Override
    public ManutencaoResponse buscaPorId(Long idManutencao) {
        log.info("[inicia] ManutencaoApplicationService - buscaPorId");
        Manutencao manutencao = manutencaoRepository.buscaPorId(idManutencao);
        log.info("[finaliza] ManutencaoApplicationService - buscaPorId");
        return new ManutencaoResponse(manutencao);
    }

    @Override
    public void alteraManutencao(Long idManutencao, ManutencaoRequest request) {
        log.info("[inicia] ManutencaoApplicationService - alteraManutencao");
        Manutencao manutencao = manutencaoRepository.buscaPorId(idManutencao);
        manutencao.altera(request);
        manutencaoRepository.salva(manutencao);
        log.info("[finaliza] ManutencaoApplicationService - alteraManutencao");
    }

    @Override
    public void deletaManutencao(Long idManutencao) {
        log.info("[inicia] ManutencaoApplicationService - deletaManutencao");
        manutencaoRepository.deleta(manutencaoRepository.buscaPorId(idManutencao).getIdManutencao());
        log.info("[finaliza] ManutencaoApplicationService - deletaManutencao");
    }
}
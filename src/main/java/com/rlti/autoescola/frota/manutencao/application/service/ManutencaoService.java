package com.rlti.autoescola.frota.manutencao.application.service;

import com.rlti.autoescola.frota.manutencao.application.api.*;

import java.util.List;

public interface ManutencaoService {
    ManutencaoIdResponse novaManutencao(String placa, ManutencaoRequest request);
    VeiculoManutencaoResponse buscaManutencoes(String placa);
    List<ManutencaoListResponse> buscaManutencoesVeiculo(String placa);
    ManutencaoResponse buscaPorId(Long idManutencao);
    void alteraManutencao(Long idManutencao, ManutencaoRequest request);
    void deletaManutencao(Long idManutencao);
}

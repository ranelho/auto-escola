package com.rlti.autoescola.frota.manutencao.application.service;

import com.rlti.autoescola.frota.manutencao.application.api.*;

import java.util.List;

public interface ManutencaoService {
    ManutencaoIdResponse saveManutencao(String placa, ManutencaoRequest request);
    VeiculoManutencaoResponse getByVeiculo(String placa);
    List<ManutencaoListResponse> getManutencaoByVeiculo(String placa);
    ManutencaoResponse getOneManutencao(Long idManutencao);
    void updateManutencao(Long idManutencao, ManutencaoRequest request);
    void deleteManutencao(Long idManutencao);
}

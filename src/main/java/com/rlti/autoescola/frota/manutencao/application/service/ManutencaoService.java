package com.rlti.autoescola.frota.manutencao.application.service;

import com.rlti.autoescola.frota.manutencao.application.api.*;

import java.util.List;

public interface ManutencaoService {
    ManutencaoIdResponse post(String placa, ManutencaoRequest request);
    VeiculoManutencaoResponse getByVeiculo(String placa);
    List<ManutencaoListResponse> getByVeiculoVeiculo(String placa);
    ManutencaoResponse getById(Long idManutencao);
    void update(Long idManutencao, ManutencaoRequest request);
    void delete(Long idManutencao);
}

package com.rlti.autoescola.frota.manutencao.application.service;

import com.rlti.autoescola.frota.manutencao.application.api.ManutencaoIdResponse;
import com.rlti.autoescola.frota.manutencao.application.api.ManutencaoListResponse;
import com.rlti.autoescola.frota.manutencao.application.api.ManutencaoRequest;
import com.rlti.autoescola.frota.manutencao.application.api.VeiculoManutencaoResponse;

import java.util.List;

public interface ManutencaoService {
    ManutencaoIdResponse novaManutencao(String placa, ManutencaoRequest request);
    VeiculoManutencaoResponse buscaManutencoes(String placa);
    List<ManutencaoListResponse> buscaManutencoesVeiculo(String placa);
}

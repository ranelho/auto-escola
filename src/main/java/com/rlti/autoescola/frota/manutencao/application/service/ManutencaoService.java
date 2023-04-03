package com.rlti.autoescola.frota.manutencao.application.service;

import com.rlti.autoescola.frota.manutencao.application.api.ManutencaoIdResponse;
import com.rlti.autoescola.frota.manutencao.application.api.ManutencaoRequest;
import com.rlti.autoescola.frota.manutencao.application.api.VeiculoManutencaoResponse;

public interface ManutencaoService {
    ManutencaoIdResponse novaManutencao(String placa, ManutencaoRequest request);
    VeiculoManutencaoResponse getManutencoesVeiculo(String placa);
}

package com.rlti.autoescola.frota.manutencao.application.service;

import com.rlti.autoescola.frota.manutencao.application.api.ManutencaoIdResponse;
import com.rlti.autoescola.frota.manutencao.application.api.ManutencaoRequest;

public interface ManutencaoService {
    ManutencaoIdResponse novaManutencao(String placa, ManutencaoRequest request);
}

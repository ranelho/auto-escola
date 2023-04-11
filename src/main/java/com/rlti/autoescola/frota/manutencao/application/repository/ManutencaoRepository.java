package com.rlti.autoescola.frota.manutencao.application.repository;

import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;

import java.util.List;

public interface ManutencaoRepository {
    Manutencao salva(Manutencao manutencao);
    List<Manutencao> findAll(Veiculo veiculo);
    Manutencao buscaPorId(Long idManutencao);
    void deleta(Long idManutencao);
}

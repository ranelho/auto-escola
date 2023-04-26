package com.rlti.autoescola.frota.manutencao.application.repository;

import com.rlti.autoescola.frota.manutencao.domain.Manutencao;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;

import java.time.LocalDate;
import java.util.List;

public interface ManutencaoRepository {
    Manutencao saveManutencao(Manutencao manutencao);
    List<Manutencao> getAllManutencoes(Veiculo veiculo);
    Manutencao getOneManutencao(Long idManutencao);
    void deleteManutencao(Long idManutencao);
    List<Manutencao> getAllManutencoesByData(LocalDate data);
}

package com.rlti.autoescola.frota.veiculo.application.repository;

import com.rlti.autoescola.frota.veiculo.domain.Veiculo;

import java.util.List;

public interface VeiculoRepository {
    Veiculo saveVeiculo(Veiculo veiculo);
    Veiculo getByPlaca(String placa);
    List<Veiculo> getAllVeiculo();
}

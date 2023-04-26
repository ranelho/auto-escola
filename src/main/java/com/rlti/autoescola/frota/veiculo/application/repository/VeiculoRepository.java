package com.rlti.autoescola.frota.veiculo.application.repository;

import com.rlti.autoescola.frota.veiculo.domain.Veiculo;

import java.util.List;
import java.util.UUID;

public interface VeiculoRepository {
    Veiculo saveVeiculos(Veiculo veiculo);
    Veiculo getByPlaca(String placa);
    List<Veiculo> getAllVeiculo();
    void deleteVeiculo(UUID idVeiculo);
}

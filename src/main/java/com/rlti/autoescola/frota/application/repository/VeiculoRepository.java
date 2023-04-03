package com.rlti.autoescola.frota.application.repository;

import com.rlti.autoescola.frota.domain.Veiculo;

import java.util.List;
import java.util.UUID;

public interface VeiculoRepository {
    Veiculo salva(Veiculo veiculo);
    Veiculo getByPlaca(String placa);
    List<Veiculo> getAll();
    void deleta(UUID idVeiculo);
}

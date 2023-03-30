package com.rlti.autoescola.frota.application.repository;

import com.rlti.autoescola.frota.domain.Veiculo;

public interface VeiculoRepository {
    Veiculo salva(Veiculo veiculo);
    Veiculo getByPlaca(String placa);
}

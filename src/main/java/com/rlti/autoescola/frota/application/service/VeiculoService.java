package com.rlti.autoescola.frota.application.service;

import com.rlti.autoescola.frota.application.api.VeiculoIdResponse;
import com.rlti.autoescola.frota.application.api.VeiculoRequest;
import com.rlti.autoescola.frota.domain.Veiculo;

import java.util.List;

public interface VeiculoService {
    VeiculoIdResponse saveVeiculo(VeiculoRequest request);
    Veiculo getByPlaca(String placa);
    List<Veiculo> getAll();
    void alteraVeiculo(String placa, VeiculoRequest request);
}

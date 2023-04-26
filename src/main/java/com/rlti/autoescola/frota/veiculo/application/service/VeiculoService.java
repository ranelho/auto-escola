package com.rlti.autoescola.frota.veiculo.application.service;

import com.rlti.autoescola.frota.veiculo.application.api.VeiculoIdResponse;
import com.rlti.autoescola.frota.veiculo.application.api.VeiculoRequest;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;

import java.util.List;

public interface VeiculoService {
    VeiculoIdResponse saveVeiculo(VeiculoRequest request);
    Veiculo getOneVeiculoByPlaca(String placa);
    List<Veiculo> getAll();
    void update(String placa, VeiculoRequest request);
    void delete(String placa);
}

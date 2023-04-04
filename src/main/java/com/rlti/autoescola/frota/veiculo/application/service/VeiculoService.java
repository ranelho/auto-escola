package com.rlti.autoescola.frota.veiculo.application.service;

import com.rlti.autoescola.frota.veiculo.application.api.VeiculoIdResponse;
import com.rlti.autoescola.frota.veiculo.application.api.VeiculoRequest;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;

import java.util.List;

public interface VeiculoService {
    VeiculoIdResponse saveVeiculo(VeiculoRequest request);
    Veiculo getByPlaca(String placa);
    List<Veiculo> getAll();
    void alteraVeiculo(String placa, VeiculoRequest request);
    void deletaVeiculo(String placa);
}

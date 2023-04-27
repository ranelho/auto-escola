package com.rlti.autoescola.frota.veiculo.application.service;

import com.rlti.autoescola.frota.veiculo.application.api.VeiculoIdResponse;
import com.rlti.autoescola.frota.veiculo.application.api.VeiculoRequest;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;

import java.util.List;

public interface VeiculoService {
    VeiculoIdResponse saveVeiculo(VeiculoRequest request);
    Veiculo getOneVeiculoByPlaca(String placa);
    List<Veiculo> getAllVeiculos();
    void updateVeiculo(String placa, VeiculoRequest request);
    void inativaVeiculo(String placa);
}

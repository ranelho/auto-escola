package com.rlti.autoescola.frota.application.service;

import com.rlti.autoescola.frota.application.api.VeiculoIdResponse;
import com.rlti.autoescola.frota.application.api.VeiculoRequest;

public interface VeiculoService {
    VeiculoIdResponse saveVeiculo(VeiculoRequest request);
}

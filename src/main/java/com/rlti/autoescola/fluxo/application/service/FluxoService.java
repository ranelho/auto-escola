package com.rlti.autoescola.fluxo.application.service;

import com.rlti.autoescola.fluxo.application.api.FluxoDeCaixaResponse;

import java.time.LocalDate;

public interface FluxoService {
    FluxoDeCaixaResponse getFluxoDiario(LocalDate data);
}

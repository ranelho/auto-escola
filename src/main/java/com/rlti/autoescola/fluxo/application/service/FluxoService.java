package com.rlti.autoescola.fluxo.application.service;

import com.rlti.autoescola.fluxo.application.api.FluxoDeCaixaResponse;
import com.rlti.autoescola.fluxo.application.api.ReceitaPagamentoResponse;

import java.time.LocalDate;
import java.util.List;

public interface FluxoService {
    FluxoDeCaixaResponse getFluxoDiario(LocalDate data);
    List<ReceitaPagamentoResponse> getReceitasPagamento(LocalDate data);
}

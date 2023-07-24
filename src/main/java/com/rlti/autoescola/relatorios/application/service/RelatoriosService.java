package com.rlti.autoescola.relatorios.application.service;

import com.rlti.autoescola.relatorios.application.api.respose.*;

import java.time.LocalDate;
import java.util.List;

public interface RelatoriosService {
    List<RelatorioClientesResponse> getAllClientes();
    List<RelatorioMatriculasAtivasResponse> getAllMatriculasAtivas();
    List<RelatorioVeiculosResponse> getAllVeiculos();
    List<RelatorioInstrutorResponse> getAllInstrutor();
    RelatorioFluxoDeCaixaResponse getRelatorioPeriodo(LocalDate dataInicial, LocalDate dataFinal);
}
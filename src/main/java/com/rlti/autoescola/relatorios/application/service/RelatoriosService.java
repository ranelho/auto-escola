package com.rlti.autoescola.relatorios.application.service;

import com.rlti.autoescola.relatorios.application.api.respose.RelatorioClientesResponse;
import com.rlti.autoescola.relatorios.application.api.respose.RelatorioInstrutorResponse;
import com.rlti.autoescola.relatorios.application.api.respose.RelatorioMatriculasAtivasResponse;
import com.rlti.autoescola.relatorios.application.api.respose.RelatorioVeiculosResponse;

import java.util.List;

public interface RelatoriosService {
    List<RelatorioClientesResponse> getAllClientes();
    List<RelatorioMatriculasAtivasResponse> getAllMatriculasAtivas();
    List<RelatorioVeiculosResponse> getAllVeiculos();
    List<RelatorioInstrutorResponse> getAllInstrutor();
}
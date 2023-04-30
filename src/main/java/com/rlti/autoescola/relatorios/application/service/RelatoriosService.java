package com.rlti.autoescola.relatorios.application.service;

import com.rlti.autoescola.relatorios.application.api.RelatorioClientesResponse;
import com.rlti.autoescola.relatorios.application.api.RelatorioMatriculasAtivasResponse;

import java.util.List;

public interface RelatoriosService {
    List<RelatorioClientesResponse> getAllClientes();
    List<RelatorioMatriculasAtivasResponse> getAllMatriculasAtivas();
}

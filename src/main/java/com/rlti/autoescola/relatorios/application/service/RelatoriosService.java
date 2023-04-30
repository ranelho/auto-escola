package com.rlti.autoescola.relatorios.application.service;

import com.rlti.autoescola.relatorios.application.api.RelatorioClientesResponse;

import java.util.List;

public interface RelatoriosService {
    List<RelatorioClientesResponse> getAllClientes();
}

package com.rlti.autoescola.empresa.application.service;


import com.rlti.autoescola.empresa.application.api.*;

import java.util.List;
import java.util.UUID;

public interface EmpresaService {
    EmpresaResponse criaEmpresa(EmpresaRequest empresaRequest);
    List<EmpresaListResponse> buscaTodosClientes();
    EmpresaDetalhadoResponse buscaEmpresaAtravesId(UUID idEmpresa);
    EmpresaDetalhadoResponseCnpj buscaEmpresaAtravesCnpj(String cnpj);
    void deletaEmpresaAtravesId(UUID idEmpresa);
    void patchAlteraEmpresa(UUID idEmpresa, EmpresaAlteracaoRequest empresaAlteracaoRequest);
}

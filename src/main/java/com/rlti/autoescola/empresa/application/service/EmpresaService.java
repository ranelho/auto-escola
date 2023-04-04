package com.rlti.autoescola.empresa.application.service;


import com.rlti.autoescola.empresa.application.api.EmpresaDetalhadoResponse;
import com.rlti.autoescola.empresa.application.api.EmpresaListResponse;
import com.rlti.autoescola.empresa.application.api.EmpresaRequest;
import com.rlti.autoescola.empresa.application.api.EmpresaResponse;

import java.util.List;
import java.util.UUID;

public interface EmpresaService {
    EmpresaResponse criaEmpresa(EmpresaRequest empresaRequest);
    List<EmpresaListResponse> buscaTodosClientes();
    EmpresaDetalhadoResponse buscaEmpresaAtravesId(UUID idEmpresa);

    EmpresaDetalhadoResponse buscaEmpresaAtravesCnpj(String cnpj);

    void deletaEmpresaAtravesId(UUID idEmpresa);
}

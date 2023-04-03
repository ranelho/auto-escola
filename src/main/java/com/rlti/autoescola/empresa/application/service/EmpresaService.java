package com.rlti.autoescola.empresa.application.service;


import com.rlti.autoescola.empresa.application.api.EmpresaListResponse;
import com.rlti.autoescola.empresa.application.api.EmpresaRequest;
import com.rlti.autoescola.empresa.application.api.EmpresaResponse;

import java.util.List;

public interface EmpresaService {
   EmpresaResponse criaEmpresa(EmpresaRequest empresaRequest);
    List<EmpresaListResponse> buscaTodosClientes();
}

package com.rlti.autoescola.empresa.domain.application.service;


import com.rlti.autoescola.empresa.domain.application.api.EmpresaRequest;
import com.rlti.autoescola.empresa.domain.application.api.EmpresaResponse;

public interface EmpresaService {
   EmpresaResponse criaEmpresa(EmpresaRequest empresaRequest);

}

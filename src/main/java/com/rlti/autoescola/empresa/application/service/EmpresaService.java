package com.rlti.autoescola.empresa.application.service;


import com.rlti.autoescola.empresa.application.api.EmpresaRequest;
import com.rlti.autoescola.empresa.application.api.EmpresaResponse;

public interface EmpresaService {
   EmpresaResponse criaEmpresa(EmpresaRequest empresaRequest);

}

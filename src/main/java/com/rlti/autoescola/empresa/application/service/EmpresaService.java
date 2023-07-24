package com.rlti.autoescola.empresa.application.service;

import com.rlti.autoescola.empresa.application.api.*;
import java.util.List;
import java.util.UUID;

public interface EmpresaService {
    EmpresaResponse saveEmpresa(EmpresaRequest empresaRequest);
    List<EmpresaListResponse> getAllEmpresas();
    EmpresaDetalhadoResponse getOneEmpresa(UUID idEmpresa);
    EmpresaDetalhadoResponseCnpj getByCnpj(String cnpj);
    void deleteEmpresa(UUID idEmpresa);
    void updateEmpresa(UUID idEmpresa, EmpresaUpdateRequest empresaUpdateRequest);
}

package com.rlti.autoescola.empresa.application.repository;

import com.rlti.autoescola.empresa.domain.Empresa;
import java.util.List;
import java.util.UUID;

public interface EmpresaRepository {
    Empresa saveEmpresa(Empresa empresa);
    List<Empresa> getAllEmpresas();
    Empresa getOneEmpresa(UUID idEmpresa);
    Empresa getByCnpj(String cnpj);
    void deleteEmpresa(UUID idEmpresa);
}
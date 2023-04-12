package com.rlti.autoescola.empresa.application.repository;

import com.rlti.autoescola.empresa.domain.Empresa;
import java.util.List;
import java.util.UUID;

public interface EmpresaRepository {
    Empresa salva(Empresa empresa);
    List<Empresa> buscaTodasEmpresas();
    Empresa buscaEmpresaAtravesId(UUID idEmpresa);
    Empresa buscaEmpresaAtravesCnpj(String cnpj);
    void deletaEmpresa(UUID idEmpresa);
}
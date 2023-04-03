package com.rlti.autoescola.empresa.application.repository;

import com.rlti.autoescola.empresa.domain.Empresa;

import java.util.List;

public interface EmpresaRepository {
    Empresa salva(Empresa empresa);

    List<Empresa> buscaTodasEmpresas();
}

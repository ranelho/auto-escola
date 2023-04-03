package com.rlti.autoescola.empresa.application.service;


import com.rlti.autoescola.empresa.application.api.EmpresaListResponse;
import com.rlti.autoescola.empresa.application.api.EmpresaResponse;
import com.rlti.autoescola.empresa.domain.Empresa;
import com.rlti.autoescola.empresa.application.api.EmpresaRequest;
import com.rlti.autoescola.empresa.application.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class EmpresaApplicationService implements EmpresaService{
    private final EmpresaRepository empresaRepository;

    @Override
    public EmpresaResponse criaEmpresa(EmpresaRequest empresaRequest) {
        log.info("[inicia] EmpresaApplicationService - criaEmpresa");
        Empresa empresa = empresaRepository.salva(new Empresa(empresaRequest));
        log.info("[finaliza] EmpresaApplicationService - criaEmpresa");
        return EmpresaResponse.builder().idEmpresa(empresa.getIdEmpresa()).build();
    }

    @Override
    public List<EmpresaListResponse> buscaTodosClientes() {
        log.info("[inicia] EmpresaApplicationService - buscaTodosClientes");
        List<Empresa> clientes = empresaRepository.buscaTodasEmpresas();
        log.info("[finaliza] EmpresaApplicationService - buscaTodosClientes");
        return EmpresaListResponse.converte(clientes);
    }
}

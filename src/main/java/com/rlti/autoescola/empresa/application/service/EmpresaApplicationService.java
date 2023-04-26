package com.rlti.autoescola.empresa.application.service;


import com.rlti.autoescola.empresa.application.api.*;
import com.rlti.autoescola.empresa.domain.Empresa;
import com.rlti.autoescola.empresa.application.repository.EmpresaRepository;
import com.rlti.autoescola.empresa.validation.ValidaCpfouCnpj;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class EmpresaApplicationService implements EmpresaService{
    private final EmpresaRepository empresaRepository;
    @Override
    public EmpresaResponse saveEmpresa(EmpresaRequest empresaRequest) {
        log.info("[inicia] EmpresaApplicationService - criaEmpresa");
        Empresa empresa = empresaRepository.saveEmpresa(new Empresa(empresaRequest));
        log.info("[finaliza] EmpresaApplicationService - criaEmpresa");
        return EmpresaResponse.builder().idEmpresa(empresa.getIdEmpresa()).build();
    }
    @Override
    public List<EmpresaListResponse> getAllEmpresas() {
        log.info("[inicia] EmpresaApplicationService - buscaTodosClientes");
        List<Empresa> clientes = empresaRepository.getAllEmpresas();
        log.info("[finaliza] EmpresaApplicationService - buscaTodosClientes");
        return EmpresaListResponse.converte(clientes);
    }
    @Override
    public EmpresaDetalhadoResponse getOneEmpresa(UUID idEmpresa) {
        log.info("[inicia] EmpresaApplicationService - buscaEmpresaAtravesId");
        Empresa empresa = empresaRepository.getOneEmpresa(idEmpresa);
        log.info("[finaliza] EmpresaApplicationService - buscaEmpresaAtravesId");
        return new EmpresaDetalhadoResponse(empresa);
    }
    @Override
    public EmpresaDetalhadoResponseCnpj getByCnpj(String cnpj) {
        log.info("[inicia] EmpresaApplicationService - buscaEmpresaAtravesCnpj");
        ValidaCpfouCnpj.validateCpfOrCnpj(cnpj);
        Empresa empresa = empresaRepository.getAllEmpresaByCnpj(cnpj);
        log.info("[finaliza] EmpresaApplicationService - buscaEmpresaAtravesCnpj");
        return new EmpresaDetalhadoResponseCnpj(empresa);
    }
    @Override
    public void deleteEmpresa(UUID idEmpresa) {
        log.info("[inicia] EmpresaApplicationService - delete");
        empresaRepository.deleteEmpresa(empresaRepository.getOneEmpresa(idEmpresa).getIdEmpresa());
        log.info("[finaliza] EmpresaApplicationService - delete");
    }

    @Override
    public void updateEmpresa(UUID idEmpresa, EmpresaAlteracaoRequest empresaAlteracaoRequest) {
        log.info("[inicia] EmpresaApplicationService - update");
        Empresa empresa = empresaRepository.getOneEmpresa(idEmpresa);
        empresa.altera(empresaAlteracaoRequest);
        empresaRepository.saveEmpresa(empresa);
        log.info("[finaliza] EmpresaApplicationService - update");
    }
}

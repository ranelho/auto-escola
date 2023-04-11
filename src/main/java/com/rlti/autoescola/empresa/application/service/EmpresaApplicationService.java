package com.rlti.autoescola.empresa.application.service;


import com.rlti.autoescola.empresa.application.api.*;
import com.rlti.autoescola.empresa.domain.Empresa;
import com.rlti.autoescola.empresa.application.repository.EmpresaRepository;
import com.rlti.autoescola.handler.validacoes.ValidaCpfouCnpj;
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
    @Override
    public EmpresaDetalhadoResponse buscaEmpresaAtravesId(UUID idEmpresa) {
        log.info("[inicia] EmpresaApplicationService - buscaEmpresaAtravesId");
        Empresa empresa = empresaRepository.buscaEmpresaAtravesId(idEmpresa);
        log.info("[finaliza] EmpresaApplicationService - buscaEmpresaAtravesId");
        return new EmpresaDetalhadoResponse(empresa);
    }
    @Override
    public EmpresaDetalhadoResponseCnpj buscaEmpresaAtravesCnpj(String cnpj) {
        log.info("[inicia] EmpresaApplicationService - buscaEmpresaAtravesCnpj");
        ValidaCpfouCnpj.validateCpfOrCnpj(cnpj);
        Empresa empresa = empresaRepository.buscaEmpresaAtravesCnpj(cnpj);
        log.info("[finaliza] EmpresaApplicationService - buscaEmpresaAtravesCnpj");
        return new EmpresaDetalhadoResponseCnpj(empresa);
    }
    @Override
    public void deletaEmpresaAtravesId(UUID idEmpresa) {
        log.info("[inicia] EmpresaApplicationService - deletaEmpresaAtravesId");
        Empresa empresa = empresaRepository.buscaEmpresaAtravesId(idEmpresa);
        empresaRepository.deletaEmpresa(empresa);
        log.info("[finaliza] EmpresaApplicationService - deletaEmpresaAtravesId");
    }

    @Override
    public void patchAlteraEmpresa(UUID idEmpresa, EmpresaAlteracaoRequest empresaAlteracaoRequest) {
        log.info("[inicia] EmpresaApplicationService - patchAlteraEmpresa");
        Empresa empresa = empresaRepository.buscaEmpresaAtravesId(idEmpresa);
        empresa.altera(empresaAlteracaoRequest);
        empresaRepository.salva(empresa);
        log.info("[finaliza] EmpresaApplicationService - patchAlteraEmpresa");
    }
}

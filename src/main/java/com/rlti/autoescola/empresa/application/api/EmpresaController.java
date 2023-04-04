package com.rlti.autoescola.empresa.application.api;

import com.rlti.autoescola.empresa.application.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EmpresaController implements EmpresaApi{

    private final EmpresaService empresaService;
    @Override
    public EmpresaResponse postEmpresa(EmpresaRequest empresaRequest) {
        log.info("[inicia] EmpresaController - postEmpresa");
        EmpresaResponse empresaCriada = empresaService.criaEmpresa(empresaRequest);
        log.info("[finaliza] EmpresaController - postEmpresa");
        return empresaCriada;
    }

    @Override
    public List<EmpresaListResponse> getEmpresas() {
        log.info("[inicia] EmpresaController - getEmpresas");
        List<EmpresaListResponse> empresas = empresaService.buscaTodosClientes();
        log.info("[finaliza] EmpresaController - getEmpresas");
        return empresas;
    }

    @Override
    public EmpresaDetalhadoResponse getEmpresaAtravesId(UUID idEmpresa) {
        log.info("[inicia] EmpresaController - getEmpresaAtravesId");
        EmpresaDetalhadoResponse empresaDetalhadoId = empresaService.buscaEmpresaAtravesId(idEmpresa);
        log.info("[finaliza] EmpresaController - getEmpresaAtravesId");
        return empresaDetalhadoId;
    }

    @Override
    public EmpresaDetalhadoResponseCnpj getEmpresaAtravesCnpj(String cnpj) {
        log.info("[inicia] EmpresaController - getEmpresaAtravesCnpj");
        EmpresaDetalhadoResponseCnpj empresaDetalhado = empresaService.buscaEmpresaAtravesCnpj(cnpj);
        log.info("[finaliza] EmpresaController - getEmpresaAtravesCnpj");
        return empresaDetalhado;
    }
    @Override
    public void deletaEmpresaAtravesId(UUID idEmpresa) {
        log.info("[inicia] EmpresaController - deletaEmpresaAtravesId");
        log.info("[IdEmpresa] {}", idEmpresa);
        empresaService.deletaEmpresaAtravesId(idEmpresa);
        log.info("[finaliza] EmpresaController - deletaEmpresaAtravesId");
    }
}
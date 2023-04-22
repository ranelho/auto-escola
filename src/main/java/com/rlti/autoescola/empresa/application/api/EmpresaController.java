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
    public EmpresaResponse post(EmpresaRequest empresaRequest) {
        log.info("[inicia] EmpresaController - post");
        EmpresaResponse empresaCriada = empresaService.criaEmpresa(empresaRequest);
        log.info("[finaliza] EmpresaController - post");
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
    public EmpresaDetalhadoResponse getById(UUID idEmpresa) {
        log.info("[inicia] EmpresaController - getById");
        EmpresaDetalhadoResponse empresaDetalhadoId = empresaService.buscaEmpresaAtravesId(idEmpresa);
        log.info("[finaliza] EmpresaController - getById");
        return empresaDetalhadoId;
    }

    @Override
    public EmpresaDetalhadoResponseCnpj getByCnpj(String cnpj) {
        log.info("[inicia] EmpresaController - getByCnpj");
        EmpresaDetalhadoResponseCnpj empresaDetalhado = empresaService.buscaEmpresaAtravesCnpj(cnpj);
        log.info("[finaliza] EmpresaController - getByCnpj");
        return empresaDetalhado;
    }
    @Override
    public void delete(UUID idEmpresa) {
        log.info("[inicia] EmpresaController - delete");
        log.info("[IdEmpresa] {}", idEmpresa);
        empresaService.delete(idEmpresa);
        log.info("[finaliza] EmpresaController - delete");
    }

    @Override
    public void update(UUID idEmpresa, EmpresaAlteracaoRequest empresaAlteracaoRequest) {
        log.info("[inicia] EmpresaController - update");
        empresaService.update(idEmpresa, empresaAlteracaoRequest);
        log.info("[inicia] EmpresaController - update");
    }
}

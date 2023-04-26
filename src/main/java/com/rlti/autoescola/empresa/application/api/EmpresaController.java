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
    public EmpresaResponse saveEmpresa(EmpresaRequest empresaRequest) {
        log.info("[inicia] EmpresaController - post");
        EmpresaResponse empresaCriada = empresaService.saveEmpresa(empresaRequest);
        log.info("[finaliza] EmpresaController - post");
        return empresaCriada;
    }

    @Override
    public List<EmpresaListResponse> getAllEmpresas() {
        log.info("[inicia] EmpresaController - getEmpresas");
        List<EmpresaListResponse> empresas = empresaService.getAllEmpresas();
        log.info("[finaliza] EmpresaController - getEmpresas");
        return empresas;
    }

    @Override
    public EmpresaDetalhadoResponse getOneEmpresa(UUID idEmpresa) {
        log.info("[inicia] EmpresaController - getById");
        EmpresaDetalhadoResponse empresaDetalhadoId = empresaService.getOneEmpresa(idEmpresa);
        log.info("[finaliza] EmpresaController - getById");
        return empresaDetalhadoId;
    }

    @Override
    public EmpresaDetalhadoResponseCnpj getByCnpj(String cnpj) {
        log.info("[inicia] EmpresaController - getByCnpj");
        EmpresaDetalhadoResponseCnpj empresaDetalhado = empresaService.getByCnpj(cnpj);
        log.info("[finaliza] EmpresaController - getByCnpj");
        return empresaDetalhado;
    }
    @Override
    public void deleteEmpresa(UUID idEmpresa) {
        log.info("[inicia] EmpresaController - delete");
        log.info("[IdEmpresa] {}", idEmpresa);
        empresaService.deleteEmpresa(idEmpresa);
        log.info("[finaliza] EmpresaController - delete");
    }

    @Override
    public void updateEmpresa(UUID idEmpresa, EmpresaAlteracaoRequest empresaAlteracaoRequest) {
        log.info("[inicia] EmpresaController - update");
        empresaService.updateEmpresa(idEmpresa, empresaAlteracaoRequest);
        log.info("[inicia] EmpresaController - update");
    }
}

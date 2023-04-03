package com.rlti.autoescola.empresa.domain.application.api;

import com.rlti.autoescola.empresa.domain.application.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ControllerEmpresa implements EmpresaApi{

    private final EmpresaService empresaService;
    @Override
    public EmpresaResponse postEmpresa(EmpresaRequest empresaRequest) {
        log.info("[inicia] ControllerEmpresa - postEmpresa");
        EmpresaResponse empresaCriado = EmpresaService.criaEmpresa(empresaRequest);
        log.info("[finaliza] ControllerEmpresa - postEmpresa");
        return empresaCriado;
    }
}

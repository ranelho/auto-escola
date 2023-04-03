package com.rlti.autoescola.empresa.application.api;

import com.rlti.autoescola.empresa.application.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}

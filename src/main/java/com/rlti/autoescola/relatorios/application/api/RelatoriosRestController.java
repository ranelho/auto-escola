package com.rlti.autoescola.relatorios.application.api;

import com.rlti.autoescola.relatorios.application.api.respose.RelatorioClientesResponse;
import com.rlti.autoescola.relatorios.application.api.respose.RelatorioInstrutorResponse;
import com.rlti.autoescola.relatorios.application.api.respose.RelatorioMatriculasAtivasResponse;
import com.rlti.autoescola.relatorios.application.api.respose.RelatorioVeiculosResponse;
import com.rlti.autoescola.relatorios.application.service.RelatoriosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class RelatoriosRestController implements RelatoriosApi {
    private final RelatoriosService relatoriosService;

    @Override
    public List<RelatorioClientesResponse> getAllClientes() {
        log.info("[inicia] - RelatoriosRestController - getAllClientes");
        List<RelatorioClientesResponse> response = relatoriosService.getAllClientes();
        log.info("[finaliza] - RelatoriosRestController - getAllClientes");
        return response;
    }

    @Override
    public List<RelatorioMatriculasAtivasResponse> getAllMatriculasAtivas() {
        log.info("[inicia] - RelatoriosRestController - getAllMatriculasAtivas");
        List<RelatorioMatriculasAtivasResponse> response = relatoriosService.getAllMatriculasAtivas();
        log.info("[finaliza] - RelatoriosRestController - getAllMatriculasAtivas");
        return response;
    }

    @Override
    public List<RelatorioVeiculosResponse> getAllVeiculos() {
        log.info("[inicia] - RelatoriosRestController - getAllVeiculos");
        List<RelatorioVeiculosResponse> response = relatoriosService.getAllVeiculos();
        log.info("[finaliza] - RelatoriosRestController - getAllVeiculos");
        return response;
    }

    @Override
    public List<RelatorioInstrutorResponse> getAllInstrutor() {
        log.info("[inicia] RelatoriosRestController - getAllInstrutor");
        List<RelatorioInstrutorResponse> response = relatoriosService.getAllInstrutor();
        log.info("[finaliza] RelatoriosRestController - getAllInstrutor");
        return response;
    }
}

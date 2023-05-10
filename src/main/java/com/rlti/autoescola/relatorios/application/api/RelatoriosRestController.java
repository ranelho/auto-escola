package com.rlti.autoescola.relatorios.application.api;

import com.rlti.autoescola.fluxo.application.api.FluxoDeCaixaResponse;
import com.rlti.autoescola.relatorios.application.api.respose.*;
import com.rlti.autoescola.relatorios.application.service.RelatoriosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class RelatoriosRestController implements RelatoriosApi {
    private final RelatoriosService relatoriosService;

    @Override
    public List<RelatorioClientesResponse> getRelatorioClientes() {
        log.info("[inicia] - RelatoriosRestController - getAllClientes");
        List<RelatorioClientesResponse> response = relatoriosService.getAllClientes();
        log.info("[finaliza] - RelatoriosRestController - getAllClientes");
        return response;
    }

    @Override
    public List<RelatorioMatriculasAtivasResponse> getRelatorioMatriculasAtivas() {
        log.info("[inicia] - RelatoriosRestController - getAllMatriculasAtivas");
        List<RelatorioMatriculasAtivasResponse> response = relatoriosService.getAllMatriculasAtivas();
        log.info("[finaliza] - RelatoriosRestController - getAllMatriculasAtivas");
        return response;
    }

    @Override
    public List<RelatorioVeiculosResponse> getRelatorioVeiculos() {
        log.info("[inicia] - RelatoriosRestController - getAllVeiculos");
        List<RelatorioVeiculosResponse> response = relatoriosService.getAllVeiculos();
        log.info("[finaliza] - RelatoriosRestController - getAllVeiculos");
        return response;
    }

    @Override
    public List<RelatorioInstrutorResponse> getRelatorioInstrutor() {
        log.info("[inicia] RelatoriosRestController - getAllInstrutor");
        List<RelatorioInstrutorResponse> response = relatoriosService.getAllInstrutor();
        log.info("[finaliza] RelatoriosRestController - getAllInstrutor");
        return response;
    }

    @Override
    public RelatorioFluxoDeCaixaResponse getRelatorioPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        log.info("[inicia] RelatoriosRestController - getRelatorioPeriodo");
        RelatorioFluxoDeCaixaResponse response = relatoriosService.getRelatorioPeriodo(dataInicial, dataFinal);
        log.info("[finaliza] RelatoriosRestController - getRelatorioPeriodo");
        return response;
    }
}

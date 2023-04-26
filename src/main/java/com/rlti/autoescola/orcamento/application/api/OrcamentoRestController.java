package com.rlti.autoescola.orcamento.application.api;

import com.rlti.autoescola.orcamento.application.service.OrcamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class OrcamentoRestController implements OrcamentoAPI {
    private final OrcamentoService orcamentoService;

    @Override
    public OrcamentoResponse saveOrcamento(OrcamentoRequest orcamentoRequest) {
        log.info("[inicia] OrcamentoRestController - criaOrcamento");
        OrcamentoResponse orcamentoCriado = orcamentoService.saveOrcamento(orcamentoRequest);
        log.info("[finaliza] OrcamentoRestController - criaOrcamento");
        return orcamentoCriado;
    }
    @Override
    public OrcamentoResponse getOneOrcamento(Long idOrcamento) {
        log.info("[inicia] OrcamentoRestController - getOrcamento");
        OrcamentoResponse orcamentoResponse = orcamentoService.getOneOrcamento(idOrcamento);
        log.info("[finaliza] OrcamentoRestController - getOrcamento");
        return orcamentoResponse;
    }
}
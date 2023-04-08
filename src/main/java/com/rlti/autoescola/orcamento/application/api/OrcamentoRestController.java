package com.rlti.autoescola.orcamento.application.api;

import com.rlti.autoescola.orcamento.application.service.OrcamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class OrcamentoRestController implements OrcamentoAPI {
    private final OrcamentoService orcamentoService;

    @Override
    public OrcamentoResponse criaOrcamento(UUID idCliente, UUID idServico, OrcamentoRequest orcamentoRequest) {
        log.info("[inicia] OrcamentoRestController - criaOrcamento");
        OrcamentoResponse orcamentoCriado = orcamentoService.criaNovoOrcamento(idCliente, idServico, orcamentoRequest);
        log.info("[finaliza] OrcamentoRestController - criaOrcamento");
        return orcamentoCriado;
    }
}

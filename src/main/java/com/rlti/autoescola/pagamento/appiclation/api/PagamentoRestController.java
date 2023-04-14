package com.rlti.autoescola.pagamento.appiclation.api;

import com.rlti.autoescola.pagamento.appiclation.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@RestController
@Log4j2
@RequiredArgsConstructor
public class PagamentoRestController implements PagamentoAPI {
    private final PagamentoService pagamentoService;

    @Override
    public List<PagamentoResponse> getPagamentoByMatricula(UUID idMatricula) {
        log.info("[inicia] PagamentoRestController - getPagamentoByMatricula");
        List<PagamentoResponse>  getPagamento = pagamentoService.getPagamentoByMatricula(idMatricula);
        log.info("[finaliza] PagamentoRestController - getPagamentoByMatricula");
        return getPagamento;
    }
}

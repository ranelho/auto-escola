package com.rlti.autoescola.pagamento.appiclation.api;

import com.rlti.autoescola.pagamento.appiclation.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
@Log4j2
@RequiredArgsConstructor
public class PagamentoRestController implements PagamentoAPI {
    private final PagamentoService pagamentoService;

    @Override
    public PagamentoResponse getPagamentoByMatricula(UUID idMatricula) {
        log.info("[inicia] PagamentoRestController - getPagamentoByMatricula");
        PagamentoResponse pagamentoCriado = pagamentoService.criaPagamento(pagamentoRequest);
        log.info("[finaliza] PagamentoRestController - getPagamentoByMatricula");
        return pagamentoCriado;
    }
}

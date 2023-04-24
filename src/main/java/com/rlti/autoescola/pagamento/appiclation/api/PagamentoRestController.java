package com.rlti.autoescola.pagamento.appiclation.api;

import com.rlti.autoescola.pagamento.appiclation.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@RestController
@Log4j2
@RequiredArgsConstructor
public class PagamentoRestController implements PagamentoAPI {
    private final PagamentoService pagamentoService;

    @Override
    public PagamentoResponse post(UUID idMatricula, PagamentoRequest pagamentoRequest) {
        log.info("[inicia] PagamentoRestController - post");
        PagamentoResponse pagamentoResponse = pagamentoService.newPagamento(idMatricula, pagamentoRequest);
        log.info("[inicia] PagamentoRestController - post");
        return pagamentoResponse;
    }
    @Override
    public List<PagamentoResponse> getByMatricula(UUID idMatricula) {
        log.info("[inicia] PagamentoRestController - getPagamentoByMatricula");
        List<PagamentoResponse>  getPagamento = pagamentoService.getPagamentoByMatricula(idMatricula);
        log.info("[finaliza] PagamentoRestController - getPagamentoByMatricula");
        return getPagamento;
    }
}

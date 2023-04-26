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
    public PagamentoResponse savePagamento(UUID idMatricula, PagamentoRequest pagamentoRequest) {
        log.info("[inicia] PagamentoRestController - post");
        PagamentoResponse pagamentoResponse = pagamentoService.savePagamento(idMatricula, pagamentoRequest);
        log.info("[finaliza] PagamentoRestController - post");
        return pagamentoResponse;
    }
    @Override
    public List<PagamentoResponse> getAllPagamentoByMatricula(UUID idMatricula) {
        log.info("[inicia] PagamentoRestController - getPagamentoByMatricula");
        List<PagamentoResponse>  getPagamento = pagamentoService.getAllPagamentoByMatricula(idMatricula);
        log.info("[finaliza] PagamentoRestController - getPagamentoByMatricula");
        return getPagamento;
    }
    @Override
    public PagamentoResponse getOnePagamento(Long idPagamento) {
        log.info("[inicia] PagamentoRestController - getById");
        PagamentoResponse pagamentoResponse = pagamentoService.getOnePagamento(idPagamento);
        log.info("[finaliza] PagamentoRestController - getById");
        return pagamentoResponse;
    }
    @Override
    public void deletePagamento(Long idPagamento) {
        log.info("[inicia] PagamentoRestController - delete");
        pagamentoService.deletePagamento(idPagamento);
        log.info("[finaliza] PagamentoRestController - delete");
    }
}
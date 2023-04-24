package com.rlti.autoescola.pagamento.appiclation.service;

import com.rlti.autoescola.pagamento.appiclation.api.PagamentoRequest;
import com.rlti.autoescola.pagamento.appiclation.api.PagamentoResponse;

import java.util.List;
import java.util.UUID;

public interface PagamentoService {
    PagamentoResponse newPagamento(UUID idMatricula, PagamentoRequest pagamentoRequest);
    List<PagamentoResponse> getPagamentoByMatricula(UUID idMatricula);
    PagamentoResponse getById(Long idPagamento);
}

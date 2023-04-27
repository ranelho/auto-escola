package com.rlti.autoescola.pagamento.appiclation.service;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.pagamento.appiclation.api.PagamentoRequest;
import com.rlti.autoescola.pagamento.appiclation.api.PagamentoResponse;
import com.rlti.autoescola.pagamento.domain.Pagamento;

import java.util.List;
import java.util.UUID;

public interface PagamentoService {
    PagamentoResponse savePagamento(UUID idMatricula, PagamentoRequest pagamentoRequest);
    List<PagamentoResponse> getAllPagamentoByMatricula(UUID idMatricula);
    PagamentoResponse getOnePagamento(Long idPagamento);
    Pagamento savePagamentoByEntrada(Matricula matricula, TipoPagamento tipoPagamentoEntrada);
    void deletePagamento(Long idPagamento);
}
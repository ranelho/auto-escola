package com.rlti.autoescola.pagamento.appiclation.service;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.pagamento.appiclation.api.PagamentoRequest;
import com.rlti.autoescola.pagamento.appiclation.api.PagamentoResponse;
import com.rlti.autoescola.pagamento.domain.Pagamento;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PagamentoService {
    PagamentoResponse newPagamento(UUID idMatricula, PagamentoRequest pagamentoRequest);
    List<PagamentoResponse> getPagamentoByMatricula(UUID idMatricula);
    PagamentoResponse getById(Long idPagamento);
    Pagamento entrada(Matricula matricula, TipoPagamento tipoPagamentoEntrada);
    void deleteById(Long idPagamento);
}
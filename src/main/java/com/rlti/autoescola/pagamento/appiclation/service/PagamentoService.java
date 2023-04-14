package com.rlti.autoescola.pagamento.appiclation.service;

import com.rlti.autoescola.pagamento.appiclation.api.PagamentoResponse;

import java.util.List;
import java.util.UUID;

public interface PagamentoService {
    List<PagamentoResponse> getPagamentoByMatricula(UUID idMatricula);
}

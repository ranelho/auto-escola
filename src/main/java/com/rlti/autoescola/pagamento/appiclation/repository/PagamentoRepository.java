package com.rlti.autoescola.pagamento.appiclation.repository;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.pagamento.domain.Pagamento;

import java.util.List;
import java.util.UUID;

public interface PagamentoRepository {
    List<Pagamento> getPagamento(Matricula matricula);
}

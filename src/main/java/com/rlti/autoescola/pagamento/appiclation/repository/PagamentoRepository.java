package com.rlti.autoescola.pagamento.appiclation.repository;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.pagamento.domain.Pagamento;

import java.math.BigDecimal;
import java.util.List;

public interface PagamentoRepository {
    List<Pagamento> getPagamento(Matricula matricula);
    BigDecimal totalPago(Matricula matricula);
    Pagamento salva(Pagamento pagamento);
}

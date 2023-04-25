package com.rlti.autoescola.pagamento.appiclation.repository;

import com.rlti.autoescola.matricula.application.api.request.MatriculaRequest;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.pagamento.domain.Pagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PagamentoRepository {
    List<Pagamento> getPagamento(Matricula matricula);
    BigDecimal totalPago(Matricula matricula);
    Pagamento salva(Pagamento pagamento);
    Pagamento getById(Long idPagamento);
    void delete(Long idPagamento);
    List<Pagamento> getAllData(LocalDate data);
}
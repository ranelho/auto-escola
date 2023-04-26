package com.rlti.autoescola.pagamento.appiclation.repository;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.pagamento.domain.Pagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PagamentoRepository {
    List<Pagamento> getAllPagamentoByMatricula(Matricula matricula);
    BigDecimal totalPago(Matricula matricula);
    Pagamento salva(Pagamento pagamento);
    Pagamento getOnePagamento(Long idPagamento);
    void delete(Long idPagamento);
    List<Pagamento> getAllData(LocalDate data);
    List<Pagamento> getCategoriaAllData(TipoPagamento tipoPagamento, LocalDate data);
}
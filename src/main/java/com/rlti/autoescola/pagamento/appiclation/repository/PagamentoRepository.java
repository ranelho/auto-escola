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
    Pagamento salvaPagamento(Pagamento pagamento);
    Pagamento getOnePagamento(Long idPagamento);
    void deletePagamento(Long idPagamento);
    List<Pagamento> getAllPagamentoByData(LocalDate data);
    List<Pagamento> getAllPagamentoByTipoPagamento(TipoPagamento tipoPagamento, LocalDate data);
    List<Pagamento> getAllDataPagamento(LocalDate dataInicial, LocalDate dataFinal);
    List<Pagamento> getAllReceitasPagamento(TipoPagamento tipoPagamento, LocalDate dataInicial, LocalDate dataFinal);
}
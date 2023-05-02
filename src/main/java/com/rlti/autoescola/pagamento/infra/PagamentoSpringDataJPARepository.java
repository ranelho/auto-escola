package com.rlti.autoescola.pagamento.infra;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PagamentoSpringDataJPARepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByMatricula(Matricula matricula);
    List<Pagamento> findByDataPagamento(LocalDate data);
    List<Pagamento> findByTipoPagamentoAndDataPagamento(TipoPagamento tipoPagamento, LocalDate data);
    List<Pagamento> findByDataPagamentoBetween(LocalDate dataInicial, LocalDate dataFinal);
    List<Pagamento> findByTipoPagamentoAndDataPagamentoBetween(TipoPagamento tipoPagamento, LocalDate dataInicial, LocalDate dataFinal);
}
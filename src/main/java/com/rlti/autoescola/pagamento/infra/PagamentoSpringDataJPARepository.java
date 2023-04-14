package com.rlti.autoescola.pagamento.infra;

import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.pagamento.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PagamentoSpringDataJPARepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByMatricula(Matricula matricula);

    //@Query("SELECT SUM(p.valorPago) FROM Pagamento p WHERE p.Matricula = :matricula")
    BigDecimal findSumValorPagoByMatricula(Matricula matricula);
}

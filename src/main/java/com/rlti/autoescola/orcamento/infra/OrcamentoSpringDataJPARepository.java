package com.rlti.autoescola.orcamento.infra;

import com.rlti.autoescola.orcamento.domain.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface OrcamentoSpringDataJPARepository extends JpaRepository<Orcamento, Long> {
    @Modifying
    @Query("DELETE FROM Orcamento o WHERE o.validade = :now")
    void deleteOrcamentoExpirado(LocalDate now);
    Optional<Orcamento> findByClienteCpf(String cpf);
}

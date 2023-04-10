package com.rlti.autoescola.orcamento.infra;

import com.rlti.autoescola.orcamento.domain.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrcamentoSpringDataJPARepository extends JpaRepository<Orcamento, Long> {
}

package com.rlti.autoescola.servico.infra;

import com.rlti.autoescola.servico.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicoSpringDataInfraRepository extends JpaRepository<Servico, UUID> {
}

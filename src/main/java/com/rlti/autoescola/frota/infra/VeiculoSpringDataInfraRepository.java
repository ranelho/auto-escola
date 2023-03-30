package com.rlti.autoescola.frota.infra;

import com.rlti.autoescola.frota.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VeiculoSpringDataInfraRepository extends JpaRepository<Veiculo, UUID> {
}

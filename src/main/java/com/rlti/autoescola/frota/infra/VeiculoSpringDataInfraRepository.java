package com.rlti.autoescola.frota.infra;

import com.rlti.autoescola.frota.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VeiculoSpringDataInfraRepository extends JpaRepository<Veiculo, UUID> {
    Optional<Veiculo> findByPlaca(String placa);
}

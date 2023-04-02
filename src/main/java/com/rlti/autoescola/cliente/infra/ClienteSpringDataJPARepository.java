package com.rlti.autoescola.cliente.infra;

import com.rlti.autoescola.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID>{
    Optional<Object> findByIdCliente(UUID idCliente);
}

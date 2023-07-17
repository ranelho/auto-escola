package com.rlti.autoescola.cliente.infra;

import com.rlti.autoescola.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID>{
    Optional<Cliente> findByCpf(String cpf);

    @Query(value = "SELECT * FROM cliente ORDER BY id_cliente LIMIT ? OFFSET ?", nativeQuery = true)
    List<Cliente> findAll(int pageSize, int offset);
}
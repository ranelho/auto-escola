package com.rlti.autoescola.cliente.infra;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.domain.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FotoSpringDataJPARepository extends JpaRepository<Foto, Long> {
    Optional<Foto> findByCliente(Cliente cliente);
}

package com.rlti.autoescola.cliente.infra;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.domain.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ImagemSpringDataJPARepository extends JpaRepository<Imagem, Long> {
    Optional<Imagem> findByCliente(Cliente cliente);
}

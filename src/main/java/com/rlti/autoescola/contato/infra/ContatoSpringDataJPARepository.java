package com.rlti.autoescola.contato.infra;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContatoSpringDataJPARepository extends JpaRepository<Contato, UUID>{
    List<Contato> findAllByCliente(Cliente cliente);
}

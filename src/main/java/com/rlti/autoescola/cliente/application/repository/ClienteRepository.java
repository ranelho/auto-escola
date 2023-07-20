package com.rlti.autoescola.cliente.application.repository;

import com.rlti.autoescola.cliente.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    Cliente saveCliente(Cliente cliente);
    Cliente findOneCliente(UUID idCliente);
    Page<Cliente> getAllClientes(Pageable pageable);
    void deleteCliente(Cliente cliente);
    Optional<Cliente> findByCpf(String cpf);
}
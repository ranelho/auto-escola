package com.rlti.autoescola.cliente.application.repository;

import com.rlti.autoescola.cliente.domain.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    Cliente saveCliente(Cliente cliente);
    Cliente findOneCliente(UUID idCliente);
    List<Cliente> getAllClientes();
    void deleteCliente(Cliente cliente);
    Optional<Cliente> findByCpf(String cpf);
}
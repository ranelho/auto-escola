package com.rlti.autoescola.cliente.application.repository;

import com.rlti.autoescola.cliente.domain.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);
    Cliente findById(UUID idCliente);
    List<Cliente> buscaTodosClientes();
    void deleteCliente(Cliente cliente);
    Optional<Cliente> findByCpf(String cpf);
}
package com.rlti.autoescola.cliente.application.repository;

import com.rlti.autoescola.cliente.domain.Cliente;

import java.util.UUID;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);
    Cliente buscaClientePorId(UUID idCliente);
}

package com.rlti.autoescola.cliente.application.repository;

import com.rlti.autoescola.cliente.domain.Cliente;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);
}

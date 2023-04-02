package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteResponse;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;

import java.util.UUID;

public interface ClienteService {
    ClienteResponse criaNovoCliente(ClienteRequest clienteRequest);
    ClienteResponse buscaClientePorId(UUID idCliente);
}

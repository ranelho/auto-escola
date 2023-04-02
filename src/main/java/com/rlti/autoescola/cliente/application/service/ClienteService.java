package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteResponse;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;

public interface ClienteService {
    ClienteResponse criaNovoCliente(ClienteRequest clienteRequest);
}

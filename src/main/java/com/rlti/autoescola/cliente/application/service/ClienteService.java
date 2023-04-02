package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.cliente.application.api.ClienteResponse;

public interface ClienteService {
    ClienteResponse criaNovoCliente(ClienteRequest clienteRequest);
}

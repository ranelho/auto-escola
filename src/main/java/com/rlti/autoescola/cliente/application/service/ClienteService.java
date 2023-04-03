package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteListResponse;
import com.rlti.autoescola.cliente.application.api.ClienteResponse;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.cliente.application.api.EditaClienteRequest;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse criaNovoCliente(ClienteRequest clienteRequest);
    ClienteResponse buscaClientePorId(UUID idCliente);
    List<ClienteListResponse> buscaTodosClientes();
    void deletaClientePorId(UUID idCliente);
    void editaCliente(UUID idCliente, EditaClienteRequest editaClienteRequest);
    ClienteResponse buscaClientePorCPF(String cpf);
}
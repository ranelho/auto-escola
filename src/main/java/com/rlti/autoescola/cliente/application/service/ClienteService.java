package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteListResponse;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.cliente.application.api.ClienteResponse;
import com.rlti.autoescola.cliente.application.api.EditaClienteRequest;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse criaNovoCliente(ClienteRequest clienteRequest);
    ClienteResponse findById(UUID idCliente);
    List<ClienteListResponse> buscaTodosClientes();
    void delete(UUID idCliente);
    void update(UUID idCliente, EditaClienteRequest editaClienteRequest);
    ClienteResponse findByCpf(String cpf);
    Cliente verificaCliente(OrcamentoRequest orcamentoRequest);
}

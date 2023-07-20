package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteListResponse;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.cliente.application.api.ClienteResponse;
import com.rlti.autoescola.cliente.application.api.EditaClienteRequest;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClienteService {
    ClienteResponse saveCliente(ClienteRequest clienteRequest);
    ClienteResponse getOneCliente(UUID idCliente);
    Page<ClienteListResponse> getAllClientes(Pageable pageable);
    void deleteCliente(UUID idCliente);
    void updateCliente(UUID idCliente, EditaClienteRequest editaClienteRequest);
    ClienteResponse getByCpf(String cpf);
    Cliente getOrcamentoByCliente(OrcamentoRequest orcamentoRequest);
}

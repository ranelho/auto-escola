package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteListResponse;
import com.rlti.autoescola.cliente.application.api.ClienteResponse;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.cliente.application.api.EditaClienteRequest;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse criaNovoCliente(ClienteRequest clienteRequest);
    ClienteResponse buscaClientePorId(UUID idCliente);
    List<ClienteListResponse> buscaTodosClientes();
    void deletaClientePorId(UUID idCliente);
    void editaCliente(UUID idCliente, EditaClienteRequest editaClienteRequest);
    ClienteResponse buscaClientePorCPF(String cpf);
    Cliente verificaCliente(OrcamentoRequest orcamentoRequest);
    void editaImagem(UUID idCliente, MultipartFile imagem) throws IOException;
}

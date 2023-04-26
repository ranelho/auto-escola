package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteListResponse;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.cliente.application.api.ClienteResponse;
import com.rlti.autoescola.cliente.application.api.EditaClienteRequest;
import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.contato.application.service.ContatoService;
import com.rlti.autoescola.empresa.validation.ValidaCpfouCnpj;
import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.orcamento.application.api.OrcamentoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ContatoService contatoService;

    @Override
    public ClienteResponse saveCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteApplicationService - criaNovoCliente");
        Cliente cliente = clienteRepository.save(new Cliente(clienteRequest));
        log.info("[finaliza] ClienteApplicationService - criaNovoCliente");
        return new ClienteResponse(cliente);
    }
    @Override
    public ClienteResponse getOneCliente(UUID idCliente) {
        log.info("[inicia] ClienteApplicationService - findById");
        Cliente cliente = clienteRepository.findById(idCliente);
        log.info("[finaliza] ClienteApplicationService - findById");
        return new ClienteResponse(cliente);
    }
    @Override
    public List<ClienteListResponse> getAllClientes() {
        log.info("[inicia] ClienteApplicationService - buscaTodosClientes");
        List<Cliente> clientes = clienteRepository.getAllClientes();
        log.info("[finaliza] ClienteApplicationService - buscaTodosClientes");
        return ClienteListResponse.converte(clientes);
    }
    @Override
    public void deleteCliente(UUID idCliente) {
        log.info("[inicia] ClienteApplicationService - delete");
        Cliente cliente = clienteRepository.findById(idCliente);
        clienteRepository.deleteCliente(cliente);
        log.info("[finaliza] ClienteApplicationService - delete");
    }
    @Override
    public void updateCliente(UUID idCliente, EditaClienteRequest editaClienteRequest) {
        log.info("[inicia] ClienteApplicationService - update");
        Cliente cliente = clienteRepository.findById(idCliente);
        cliente.altera(editaClienteRequest);
        clienteRepository.save(cliente);
        log.info("[finaliza] ClienteApplicationService - update");
    }
    @Override
    public ClienteResponse getByCpf(String cpf) {
        log.info("[inicia] ClienteApplicationService - findByCpf");
        ValidaCpfouCnpj.validateCpfOrCnpj(cpf);
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,"Cliente não encontrado!"));;
        log.info("[finaliza] ClienteApplicationService - findByCpf");
        return new ClienteResponse(cliente);
    }

    @Override
    public Cliente verificaCliente(OrcamentoRequest orcamentoRequest) {
        log.info("[inicia] ClienteApplicationService - verificaCliente");
        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(orcamentoRequest.getCpf());
        Cliente cliente = clienteOptional.orElseGet(() -> clienteRepository.save(new Cliente(orcamentoRequest)));
        contatoService.verificaContato(cliente, orcamentoRequest);
        log.info("[inicia] ClienteApplicationService - verificaCliente");
        return cliente;
    }
}
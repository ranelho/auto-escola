package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteListResponse;
import com.rlti.autoescola.cliente.application.api.ClienteResponse;
import com.rlti.autoescola.cliente.application.api.EditaClienteRequest;
import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.contato.application.repository.ContatoRepository;
import com.rlti.autoescola.contato.application.service.ContatoService;
import com.rlti.autoescola.contato.domain.Contato;
import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.handler.validacoes.ValidaCpfouCnpj;
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
    public ClienteResponse criaNovoCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteApplicationService - criaNovoCliente");
        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
        log.info("[finaliza] ClienteApplicationService - criaNovoCliente");
        return new ClienteResponse(cliente);
    }
    @Override
    public ClienteResponse buscaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteApplicationService - buscaClientePorId");
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        log.info("[finaliza] ClienteApplicationService - buscaClientePorId");
        return new ClienteResponse(cliente);
    }
    @Override
    public List<ClienteListResponse> buscaTodosClientes() {
        log.info("[inicia] ClienteApplicationService - buscaTodosClientes");
        List<Cliente> clientes = clienteRepository.buscaTodosClientes();
        log.info("[finaliza] ClienteApplicationService - buscaTodosClientes");
        return ClienteListResponse.converte(clientes);
    }
    @Override
    public void deletaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteApplicationService - deletaClientePorId");
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        clienteRepository.deletaCliente(cliente);
        log.info("[finaliza] ClienteApplicationService - deletaClientePorId");
    }
    @Override
    public void editaCliente(UUID idCliente, EditaClienteRequest editaClienteRequest) {
        log.info("[inicia] ClienteApplicationService - editaCliente");
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        cliente.altera(editaClienteRequest);
        clienteRepository.salva(cliente);
        log.info("[finaliza] ClienteApplicationService - editaCliente");
    }
    @Override
    public ClienteResponse buscaClientePorCPF(String cpf) {
        log.info("[inicia] ClienteApplicationService - buscaClientePorCPF");
        ValidaCpfouCnpj.validateCpfOrCnpj(cpf);
        Cliente cliente = clienteRepository.buscaClientePorCPF(cpf)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,"Cliente não encontrado!"));;
        log.info("[finaliza] ClienteApplicationService - buscaClientePorCPF");
        return new ClienteResponse(cliente);
    }

    @Override
    public Cliente verificaCliente(OrcamentoRequest orcamentoRequest) {
        log.info("[inicia] ClienteApplicationService - verificaCliente");
        //busca no banco
        Optional<Cliente> clienteOptional = clienteRepository.buscaClientePorCPF(orcamentoRequest.getCpf());
        //caso cliente nao econtrado cria o cliente
        Cliente cliente = clienteOptional.orElseGet(() -> clienteRepository.salva(new Cliente(orcamentoRequest)));
        //chama verificação se existe um contato para o cliente
        contatoService.verificaContato(cliente, orcamentoRequest);
        log.info("[inicia] ClienteApplicationService - verificaCliente");
        return cliente;
    }
}
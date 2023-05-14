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
import com.rlti.autoescola.security.infra.UserRepository;
import com.rlti.autoescola.security.user.User;
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
    private final UserRepository userRepository;

    @Override
    public ClienteResponse saveCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteApplicationService - saveCliente");
        Cliente cliente = clienteRepository.saveCliente(new Cliente(clienteRequest));
        User user = userRepository.save(new User(clienteRequest));
        saveUserCliente(user, cliente);
        log.info("[finaliza] ClienteApplicationService - saveCliente");
        return new ClienteResponse(cliente);
    }
    public void saveUserCliente(User user, Cliente cliente){
        log.info("[inicia] ClienteApplicationService - saveUserCliente");
        Cliente client = clienteRepository.findOneCliente(cliente.getIdCliente());
        client.insertUser(user);
        clienteRepository.saveCliente(client);
        log.info("[finaliza] ClienteApplicationService - saveUserCliente");
    }
    @Override
    public ClienteResponse getOneCliente(UUID idCliente) {
        log.info("[inicia] ClienteApplicationService - getOneCliente");
        Cliente cliente = clienteRepository.findOneCliente(idCliente);
        log.info("[finaliza] ClienteApplicationService - getOneCliente");
        return new ClienteResponse(cliente);
    }
    @Override
    public List<ClienteListResponse> getAllClientes() {
        log.info("[inicia] ClienteApplicationService - getAllClientes");
        List<Cliente> clientes = clienteRepository.getAllClientes();
        log.info("[finaliza] ClienteApplicationService - getAllClientes");
        return ClienteListResponse.converte(clientes);
    }
    @Override
    public void deleteCliente(UUID idCliente) {
        log.info("[inicia] ClienteApplicationService - deleteCliente");
        Cliente cliente = clienteRepository.findOneCliente(idCliente);
        clienteRepository.deleteCliente(cliente);
        log.info("[finaliza] ClienteApplicationService - deleteCliente");
    }
    @Override
    public void updateCliente(UUID idCliente, EditaClienteRequest editaClienteRequest) {
        log.info("[inicia] ClienteApplicationService - updateCliente");
        Cliente cliente = clienteRepository.findOneCliente(idCliente);
        cliente.altera(editaClienteRequest);
        clienteRepository.saveCliente(cliente);
        log.info("[finaliza] ClienteApplicationService - updateCliente");
    }
    @Override
    public ClienteResponse getByCpf(String cpf) {
        log.info("[inicia] ClienteApplicationService - getByCpf");
        ValidaCpfouCnpj.validateCpfOrCnpj(cpf);
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST,"Cliente não encontrado!"));;
        log.info("[finaliza] ClienteApplicationService - getByCpf");
        return new ClienteResponse(cliente);
    }

    @Override
    public Cliente getOrcamentoByCliente(OrcamentoRequest request) {
        log.info("[inicia] ClienteApplicationService - getOrcamentoByCliente");
        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(request.getCpf());
        Cliente cliente = clienteOptional.orElseGet(() -> clienteRepository.saveCliente(new Cliente(request)));
        contatoService.getOrcamentoByCliente(cliente, request);
        log.info("[inicia] ClienteApplicationService - getOrcamentoByCliente");
        return cliente;
    }
}
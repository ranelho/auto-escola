package com.rlti.autoescola.cliente.application.service;

import com.rlti.autoescola.cliente.application.api.ClienteResponse;
import com.rlti.autoescola.cliente.application.repository.ClienteRepository;
import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.application.api.ClienteRequest;
import com.rlti.autoescola.cliente.infra.ClienteInfraRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criaNovoCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteResponse - criaNovoCliente");
        log.info("cpf - {}", clienteRequest.getCpf());
        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
        log.info("[finaliza] ClienteResponse - criaNovoCliente");
        return new ClienteResponse(cliente);
    }
    @Override
    public ClienteResponse buscaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteResponse - buscaClientePorId");
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        log.info("[finaliza] ClienteResponse - buscaClientePorId");
        return new ClienteResponse(cliente);
    }
}

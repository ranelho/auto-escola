package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ClienteRestController implements ClienteAPI {

    private final ClienteService clienteService;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteRestController - criaCliente");
        log.info("cpf - {}", clienteRequest.getCpf());
        ClienteResponse clienteCriado = clienteService.criaNovoCliente(clienteRequest);
        log.info("[finaliza] ClienteRestController - criaCliente");
        return clienteCriado;
    }
    @Override
    public ClienteResponse buscaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteRestController - buscaClientePorId");
        log.info("[idCliente] {}", idCliente);
        ClienteResponse buscaCliente = clienteService.buscaClientePorId(idCliente);
        log.info("[finaliza] ClienteRestController - buscaClientePorId");
        return buscaCliente;
    }
}

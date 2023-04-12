package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ClienteRestController implements ClienteAPI {
    private final ClienteService clienteService;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteRestController - criaCliente");
        ClienteResponse clienteCriado = clienteService.criaNovoCliente(clienteRequest);
        log.info("[finaliza] ClienteRestController - criaCliente");
        return clienteCriado;
    }
    @Override
    public ClienteResponse buscaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteRestController - buscaClientePorId");
        ClienteResponse buscaCliente = clienteService.buscaClientePorId(idCliente);
        log.info("[finaliza] ClienteRestController - buscaClientePorId");
        return buscaCliente;
    }
    @Override
    public ClienteResponse buscaClientePorCPF(String cpf) {
        log.info("[inicia] ClienteRestController - buscaClientePorCPF");
        ClienteResponse buscaCPF = clienteService.buscaClientePorCPF(cpf);
        log.info("[finaliza] ClienteRestController - buscaClientePorCPF");
        return buscaCPF;
    }
    @Override
    public List<ClienteListResponse> visualizaTodosClientes() {
        log.info("[inicia] ClienteRestController - buscaTodosClientes");
        List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
        log.info("[finaliza] ClienteRestController - buscaTodosClientes");
        return clientes;
    }
    @Override
    public void deletaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteRestController - deletaClientePorId");
        clienteService.deletaClientePorId(idCliente);
        log.info("[finaliza] ClienteRestController - deletaClientePorId");
    }
    @Override
    public void editaCliente(UUID idCliente, @Valid EditaClienteRequest editaClienteRequest) {
        log.info("[inicia] ClienteRestController - editaCliente");
        clienteService.editaCliente(idCliente, editaClienteRequest);
        log.info("[idCliente] {}", idCliente);
        log.info("[finaliza] ClienteRestController - editaCliente");
    }
}
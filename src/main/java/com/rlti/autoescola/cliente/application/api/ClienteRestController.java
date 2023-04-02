package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@Log4j2
public class ClienteRestController implements ClienteAPI {
    private final ClienteService clienteApplicationService;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteRestController - criaCliente");
        ClienteResponse clienteCriado = clienteApplicationService.criaNovoCliente(clienteRequest);
        log.info("[finaliza] ClienteRestController - criaCliente");
        return clienteCriado;
    }
}

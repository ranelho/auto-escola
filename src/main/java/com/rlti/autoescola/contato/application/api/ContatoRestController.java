package com.rlti.autoescola.contato.application.api;

import com.rlti.autoescola.cliente.application.api.ClienteContatosResponse;
import com.rlti.autoescola.contato.application.service.ContatoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ContatoRestController implements ContatoApi {
    private final ContatoService contatoService;

    @Override
    public ContatoResponse post(UUID idCliente, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoRestController - post");
        ContatoResponse contatoCriado = contatoService.criaNovoContato(idCliente, contatoRequest);
        log.info("[finaliza] ContatoRestController - post");
        return contatoCriado;
    }
    @Override
    public ContatoResponse findById(UUID idContato) {
        log.info("[inicia] ContatoRestController - findById");
        ContatoResponse buscaContato = contatoService.findById(idContato);
        log.info("[finaliza] ContatoRestController - findById");
        return buscaContato;
    }
    @Override
    public ClienteContatosResponse getAll(UUID idCliente) {
        log.info("[inicia] ContatoRestController - getAll");
        ClienteContatosResponse response = contatoService.buscaContatosDoCliente(idCliente);
        log.info("[finaliza] ContatoRestController - getAll");
        return response;
    }
    @Override
    public void delete(UUID idContato) {
        log.info("[inicia] ContatoRestController - delete");
        contatoService.delete(idContato);
        log.info("[finaliza] ContatoRestController - delete");
    }
    @Override
    public void update(UUID idContato, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoRestController - update");
        contatoService.update(idContato, contatoRequest);
        log.info("[finaliza] ContatoRestController - update");
    }
}

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
    public ContatoResponse saveContato(UUID idCliente, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoRestController - saveContato");
        ContatoResponse response = contatoService.saveContato(idCliente, contatoRequest);
        log.info("[finaliza] ContatoRestController - saveContato");
        return response;
    }
    @Override
    public ContatoResponse getOneContato(UUID idContato) {
        log.info("[inicia] ContatoRestController - getOneContato");
        ContatoResponse response = contatoService.getOneContato(idContato);
        log.info("[finaliza] ContatoRestController - getOneContato");
        return response;
    }
    @Override
    public ClienteContatosResponse getAllContatosCliente(UUID idCliente) {
        log.info("[inicia] ContatoRestController - getAllContatosCliente");
        ClienteContatosResponse response = contatoService.getAllContatosCliente(idCliente);
        log.info("[finaliza] ContatoRestController - getAllContatosCliente");
        return response;
    }
    @Override
    public void deleteContato(UUID idContato) {
        log.info("[inicia] ContatoRestController - deleteContato");
        contatoService.deleteContato(idContato);
        log.info("[finaliza] ContatoRestController - deleteContato");
    }
    @Override
    public void updateContato(UUID idContato, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoRestController - updateContato");
        contatoService.updateContato(idContato, contatoRequest);
        log.info("[finaliza] ContatoRestController - updateContato");
    }
}
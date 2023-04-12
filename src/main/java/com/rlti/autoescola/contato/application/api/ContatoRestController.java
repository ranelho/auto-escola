package com.rlti.autoescola.contato.application.api;

import com.rlti.autoescola.cliente.application.api.ClienteContatosResponse;
import com.rlti.autoescola.contato.application.service.ContatoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ContatoRestController implements ContatoApi {
    private final ContatoService contatoService;

    @Override
    public ContatoResponse criaContato(UUID idCliente, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoRestController - criaContato");
        ContatoResponse contatoCriado = contatoService.criaNovoContato(idCliente, contatoRequest);
        log.info("[finaliza] ContatoRestController - criaContato");
        return contatoCriado;
    }
    @Override
    public ContatoResponse buscaContatoPorId(UUID idContato) {
        log.info("[inicia] ContatoRestController - buscaContatoPorId");
        ContatoResponse buscaContato = contatoService.buscaContatoPorId(idContato);
        log.info("[finaliza] ContatoRestController - buscaContatoPorId");
        return buscaContato;
    }
    @Override
    public ClienteContatosResponse visualizaContatosDoCliente(UUID idCliente) {
        log.info("[inicia] ContatoRestController - visualizaContatosDoCliente");
        ClienteContatosResponse response = contatoService.buscaContatosDoCliente(idCliente);
        log.info("[finaliza] ContatoRestController - visualizaContatosDoCliente");
        return response;
    }
    @Override
    public void deletaContatoPorId(UUID idContato) {
        log.info("[inicia] ContatoRestController - deletaContatoPorId");
        contatoService.deletaContatoPorId(idContato);
        log.info("[finaliza] ContatoRestController - deletaContatoPorId");
    }
    @Override
    public void editaContato(UUID idContato, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoRestController - editaContato");
        contatoService.editaContato(idContato, contatoRequest);
        log.info("[finaliza] ContatoRestController - editaContato");
    }
}
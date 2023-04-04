package com.rlti.autoescola.contato.application.api;

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
        log.info("[idContato] {}", idContato);
        ContatoResponse buscaContato = contatoService.buscaContatoPorId(idContato);
        log.info("[finaliza] ContatoRestController - buscaContatoPorId");
        return buscaContato;
    }
    @Override
    public List<ContatoResponse> visualizaContatosDoCliente(UUID idCliente) {
        log.info("[inicia] ContatoRestController - visualizaContatosDoCliente");
        List<ContatoResponse> contatoResponseList = contatoService.buscaContatosDoCliente(idCliente);
        log.info("[inicia] ContatoRestController - visualizaContatosDoCliente");
        return contatoResponseList;
    }
}

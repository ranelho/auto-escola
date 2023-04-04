package com.rlti.autoescola.contato.application.api;

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
    public ContatoResponse criaContato(UUID idCliente, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoRestController - criaContato");
        ContatoResponse contatoCriado = contatoService.criaNovoContato(idCliente, contatoRequest);
        log.info("[finaliza] ContatoRestController - criaContato");
        return contatoCriado;
    }
}

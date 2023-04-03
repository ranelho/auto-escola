package com.rlti.autoescola.contato.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("v1/contato")
public interface ContatoApi {

    @PostMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ContatoResponse criaContato(@PathVariable UUID idCliente, @Valid @RequestBody ContatoRequest contatoRequest);
}

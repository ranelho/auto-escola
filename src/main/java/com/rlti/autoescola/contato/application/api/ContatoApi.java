package com.rlti.autoescola.contato.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/contato")
public interface ContatoApi {

    @PostMapping("/{cpf}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ContatoResponse postContato(@PathVariable String cpf, @Valid @RequestBody ContatoRequest contatoRequest);
}

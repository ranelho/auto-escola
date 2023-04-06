package com.rlti.autoescola.contato.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/contato")
public interface ContatoApi {

    @PostMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ContatoResponse criaContato(@PathVariable UUID idCliente, @Valid @RequestBody ContatoRequest contatoRequest);

    @GetMapping(value = "/{idContato}")
    @ResponseStatus(code = HttpStatus.OK)
    ContatoResponse buscaContatoPorId(@PathVariable UUID idContato);

    @GetMapping(value = "/cliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    List<ContatoResponse> visualizaContatosDoCliente(@PathVariable UUID idCliente);

}

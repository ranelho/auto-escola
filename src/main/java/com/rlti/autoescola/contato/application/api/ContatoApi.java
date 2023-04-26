package com.rlti.autoescola.contato.application.api;

import com.rlti.autoescola.cliente.application.api.ClienteContatosResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.UUID;

@RequestMapping("v1/contato")
public interface ContatoApi {

    @PostMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ContatoResponse post(@PathVariable UUID idCliente, @Valid @RequestBody ContatoRequest contatoRequest);

    @GetMapping(value = "/{idContato}")
    @ResponseStatus(code = HttpStatus.OK)
    ContatoResponse findById(@PathVariable UUID idContato);

    @GetMapping(value = "/all-contatos-cliente/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteContatosResponse getAll(@PathVariable UUID idCliente);

    @DeleteMapping("/{idContato}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID idContato);

    @PatchMapping("/{idContato}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void update(@PathVariable UUID idContato, @Valid @RequestBody ContatoRequest contatoRequest);
}
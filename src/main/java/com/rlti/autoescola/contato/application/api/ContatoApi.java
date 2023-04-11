package com.rlti.autoescola.contato.application.api;

import com.rlti.autoescola.cliente.application.api.ClienteContatosResponse;
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
    @ResponseStatus(code = HttpStatus.OK)
    ClienteContatosResponse visualizaContatosDoCliente(@PathVariable UUID idCliente);

    @DeleteMapping("/{idContato}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaContatoPorId(@PathVariable UUID idContato);

    @PatchMapping("/{idContato}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void editaContato(@PathVariable UUID idContato, @Valid @RequestBody ContatoRequest contatoRequest);
}
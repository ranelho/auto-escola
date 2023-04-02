package com.rlti.autoescola.cliente.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse criaCliente(@Valid @RequestBody ClienteRequest clienteRequest);

    @GetMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse buscaClientePorId(@PathVariable UUID idCliente);
}

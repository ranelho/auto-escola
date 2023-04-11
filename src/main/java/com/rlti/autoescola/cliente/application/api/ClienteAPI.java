package com.rlti.autoescola.cliente.application.api;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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

    @GetMapping(value = "/cpf/{cpf}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse buscaClientePorCPF(@PathVariable String cpf);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ClienteListResponse> visualizaTodosClientes();

    @DeleteMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaClientePorId(@PathVariable UUID idCliente);

    @PatchMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void editaCliente(@PathVariable UUID idCliente, @Valid @RequestBody EditaClienteRequest editaClienteRequest);
}

package com.rlti.autoescola.cliente.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/v1/cliente")
public interface ClienteAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse post(@Valid @RequestBody ClienteRequest clienteRequest);

    @GetMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse findById(@PathVariable UUID idCliente);

    @GetMapping(value = "/cpf")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse findByCpf(@RequestParam String cpf);

    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    List<ClienteListResponse> getAll();

    @DeleteMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID idCliente);

    @PatchMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void update(@PathVariable UUID idCliente, @Valid @RequestBody EditaClienteRequest editaClienteRequest);

    @PutMapping("/{idCliente}/imagem")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void novaImagem(@PathVariable UUID idCliente, @RequestParam("imagem") MultipartFile imagem) throws IOException;
}